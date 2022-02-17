package com.recruiting.backend.repo;

import com.recruiting.backend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    void deleteCandidateById(Long id);
    Optional<Candidate> findCandidateById(Long id);
}
