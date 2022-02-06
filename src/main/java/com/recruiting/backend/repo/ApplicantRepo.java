package com.recruiting.backend.repo;

import com.recruiting.backend.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
    void deleteApplicantById(Long id);
    Optional<Applicant> findApplicantById(Long id);
}
