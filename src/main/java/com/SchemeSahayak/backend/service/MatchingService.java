package com.SchemeSahayak.backend.service;

import com.SchemeSahayak.backend.entity.EntrepreneurProfile;
import com.SchemeSahayak.backend.entity.Scheme;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MatchingService {

    public List<Map<String, Object>> findMatches(
            EntrepreneurProfile profile,
            List<Scheme> schemes) {

        List<Map<String, Object>> results = new ArrayList<>();

        for (Scheme scheme : schemes) {

            int score = 0;
            List<String> reasons = new ArrayList<>();

            if (scheme.getCategory() == null ||
                    scheme.getCategory().equalsIgnoreCase(profile.getCategory())) {

                score += 25;
                reasons.add("Category matches");
            }

            if (scheme.getMaxIncome() == null ||
                    profile.getIncome() <= scheme.getMaxIncome()) {

                score += 20;
                reasons.add("Income is within limit");
            }

            if (scheme.getState() == null ||
                    scheme.getState().equalsIgnoreCase("ALL") ||
                    scheme.getState().equalsIgnoreCase(profile.getState())) {

                score += 15;
                reasons.add("State is eligible");
            }

            if (scheme.getBusinessType() == null ||
                    scheme.getBusinessType().equalsIgnoreCase(profile.getBusinessType())) {

                score += 20;
                reasons.add("Business type matches");
            }

            if (scheme.getMaxFunding() == null ||
                    profile.getFunding() <= scheme.getMaxFunding()) {

                score += 10;
                reasons.add("Funding requirement matches");
            }

            if ((scheme.getMinAge() == null ||
                    profile.getAge() >= scheme.getMinAge())
                    &&
                    (scheme.getMaxAge() == null ||
                    profile.getAge() <= scheme.getMaxAge())) {

                score += 10;
                reasons.add("Age requirement matches");
            }

            Map<String, Object> result = new HashMap<>();

            result.put("schemeId", scheme.getId());
            result.put("scheme", scheme.getName());
            result.put("matchScore", score);
            result.put("reasons", reasons);

            results.add(result);
        }

        results.sort((a, b) ->
                Integer.compare(
                        (Integer) b.get("matchScore"),
                        (Integer) a.get("matchScore")
                )
        );

        return results;
    }
}