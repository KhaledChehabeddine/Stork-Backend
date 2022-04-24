package com.recruiting.backend.repo;

import com.recruiting.backend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Long> {
    void deleteFeedbackById(Long id);
    void deleteFeedbackByCandidateID(Long candidateId);
    void deleteFeedbackByManagerID(Long managerId);
    Optional<Feedback> findFeedbackById(Long id);
}