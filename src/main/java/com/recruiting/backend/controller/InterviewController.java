package com.recruiting.backend.controller;

import com.recruiting.backend.model.Interview;
import com.recruiting.backend.service.InterviewService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {
    private final InterviewService interviewService;

    public InterviewController(InterviewService interviewService) {
        this.interviewService = interviewService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Interview>> getAllInterviews() {
        List<Interview> interviews = interviewService.findAllInterviews();
        return new ResponseEntity<>(interviews, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Interview> getInterviewById(@RequestParam("id") Long id) {
        Interview interview = interviewService.findInterviewById(id);
        return new ResponseEntity<>(interview, HttpStatus.OK);
    }

    @GetMapping("/candidate")
    public ResponseEntity<List<Interview>> getInterviewsByCandidateId(@RequestParam("candidateId") Long candidateId) {
        List<Interview> lst = interviewService.findInterviewsByCandidateId(candidateId);
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }

    @GetMapping("/candidate/num")
    public ResponseEntity<Integer> getNumAllInterviews(@RequestParam("candidateId") Long candidateId) {
        Integer len = interviewService.findInterviewsByCandidateId(candidateId).size();
        return new ResponseEntity<>(len, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Interview> addInterview(@RequestBody Interview interview) {
        Interview newInterview = interviewService.addInterview(interview);
        return new ResponseEntity<>(newInterview, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Interview> updateInterview(@RequestBody Interview interview) {
        Interview updatedInterview = interviewService.updateInterview(interview);
        return new ResponseEntity<>(updatedInterview, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteInterview(@RequestParam("id") Long id) {
        interviewService.deleteInterview(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
