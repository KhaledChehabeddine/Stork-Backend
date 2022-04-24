package com.recruiting.backend.repo;

import com.recruiting.backend.model.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Long> {
    void deleteInterviewById(Long id);
    void deleteInterviewsByCandidateId(Long candidateId);
    void deleteInterviewsByManagerId(Long managerId);
    Optional<Interview> findInterviewById(Long id);
    Optional<List<Interview>> findInterviewsByCandidateId(Long candidateId);
    Optional<List<Interview>> findInterviewsByManagerId(Long managerId);
}
