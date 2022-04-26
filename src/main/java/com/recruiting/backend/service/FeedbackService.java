package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Feedback;
import com.recruiting.backend.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {
    private final FeedbackRepo feedbackRepo;

    @Autowired
    public FeedbackService(FeedbackRepo feedbackRepo) { this.feedbackRepo = feedbackRepo;}

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public List<Feedback> findAllFeedbacks() {
        return feedbackRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Feedback updateFeedback(Feedback feedback) {
        return feedbackRepo.save(feedback);
    }

    public Feedback findFeedbackById(Long id) {
        return feedbackRepo.findFeedbackById(id)
                .orElseThrow(() -> new UserNotFoundException("Feedback with id: '" + id + "' is not found."));
    }

    public List<Feedback> findFeedbacksByCandidateId(Long candidateId) {
        return feedbackRepo.findFeedbacksByCandidateId(candidateId)
                .orElseThrow(() -> new UserNotFoundException("Candidate with id: " + candidateId + " is not found."));
    }

    public void deleteFeedback(Long id) {
        feedbackRepo.deleteFeedbackById(id);
    }

    public void deleteFeedbackByCandidateId(Long candidateId) {
        feedbackRepo.deleteFeedbackByCandidateId(candidateId);
    }
}
