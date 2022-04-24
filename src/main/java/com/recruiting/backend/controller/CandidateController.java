package com.recruiting.backend.controller;

import com.recruiting.backend.model.Candidate;
import com.recruiting.backend.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.findAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping("/all/jobPosition")
    public ResponseEntity<List<Candidate>> getAllCandidatesByJobPositionId(@RequestParam("jobPositionId") Long id) {
        List<Candidate> candidates = candidateService.findCandidatesByJobPositionId(id);
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Candidate> getCandidateById(@RequestParam("id") Long id) {
        Candidate candidate = candidateService.findCandidateById(id);
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        Candidate newCandidate = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(newCandidate, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate) {
        Candidate updatedCandidate = candidateService.updateCandidate(candidate);
        return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteCandidate(@RequestParam("id") Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete/all/job")
    public ResponseEntity<?> deleteCandidatesByJobPositionId(@RequestParam("jobPositionId") Long jobPositionId) {
        candidateService.deleteCandidatesByJobPositionId(jobPositionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
