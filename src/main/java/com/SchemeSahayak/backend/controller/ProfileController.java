package com.SchemeSahayak.backend.controller;

import com.SchemeSahayak.backend.entity.EntrepreneurProfile;
import com.SchemeSahayak.backend.repository.ProfileRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "http://localhost:5173")
public class ProfileController {

    private final ProfileRepository repository;

    public ProfileController(ProfileRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public EntrepreneurProfile createProfile(
            @RequestBody EntrepreneurProfile profile) {

        return repository.save(profile);
    }
}