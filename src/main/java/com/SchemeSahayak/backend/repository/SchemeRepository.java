package com.SchemeSahayak.backend.repository;

import com.SchemeSahayak.backend.entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchemeRepository
        extends JpaRepository<Scheme, Long> {
}