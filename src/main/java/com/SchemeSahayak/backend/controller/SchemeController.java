package com.SchemeSahayak.backend.controller;

import com.SchemeSahayak.backend.entity.Scheme;
import com.SchemeSahayak.backend.repository.SchemeRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schemes")
@CrossOrigin(origins = "http://localhost:5173")
public class SchemeController {

    private final SchemeRepository schemeRepository;

    public SchemeController(SchemeRepository schemeRepository) {
        this.schemeRepository = schemeRepository;
    }

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Scheme getScheme(@PathVariable Long id) {
        return schemeRepository.findById(id)
                .orElseThrow();
    }
}