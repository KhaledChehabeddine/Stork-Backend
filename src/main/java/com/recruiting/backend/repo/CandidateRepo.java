package com.recruiting.backend.repo;

import com.recruiting.backend.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandidateRepo extends JpaRepository<Candidate, Long> {
    void deleteCandidateById(Long id);
    void deleteCandidatesByJobPositionId(Long jobPositionId);
    Optional<Candidate> findCandidateById(Long id);
    Optional<List<Candidate>> findCandidatesByJobPositionId(Long jobPositionId);
}
