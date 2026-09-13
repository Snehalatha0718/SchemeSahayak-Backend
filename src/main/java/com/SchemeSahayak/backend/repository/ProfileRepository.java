package com.SchemeSahayak.backend.repository;

import com.SchemeSahayak.backend.entity.EntrepreneurProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository
        extends JpaRepository<EntrepreneurProfile, Long> {
}