package com.recruiting.backend.controller;

import com.recruiting.backend.model.Feedback;
import com.recruiting.backend.service.FeedbackService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Feedback>> getAllFeedbacks(@RequestParam("candidateId") Long id) {
        List<Feedback> feedbacks = feedbackService.findFeedbacksByCandidateId(id);
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Feedback> getFeedbackById(@RequestParam("id") Long id) {
        Feedback feedback = feedbackService.findFeedbackById(id);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) {
        Feedback newFeedback = feedbackService.addFeedback(feedback);
        return new ResponseEntity<>(newFeedback, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback) {
        Feedback updatedFeedback = feedbackService.updateFeedback(feedback);
        return new ResponseEntity<>(updatedFeedback, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteFeedback(@RequestParam("id") Long id) {
        feedbackService.deleteFeedback(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
