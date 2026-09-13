package com.SchemeSahayak.backend.controller;

import com.SchemeSahayak.backend.entity.EntrepreneurProfile;
import com.SchemeSahayak.backend.entity.Scheme;
import com.SchemeSahayak.backend.repository.SchemeRepository;
import com.SchemeSahayak.backend.service.MatchingService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/match")
@CrossOrigin(origins = "http://localhost:5173")
public class MatchingController {

    private final MatchingService matchingService;
    private final SchemeRepository schemeRepository;

    public MatchingController(
            MatchingService matchingService,
            SchemeRepository schemeRepository) {

        this.matchingService = matchingService;
        this.schemeRepository = schemeRepository;
    }

    @PostMapping
    public List<Map<String, Object>> matchSchemes(
            @RequestBody EntrepreneurProfile profile) {

        List<Scheme> schemes = schemeRepository.findAll();

        return matchingService.findMatches(profile, schemes);
    }
}