package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Candidate;
import com.recruiting.backend.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
    private final CandidateRepo candidateRepo;

    @Autowired
    public CandidateService(CandidateRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public List<Candidate> findAllCandidates() {
        return candidateRepo.findAll();
    }

    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public Candidate findCandidateById(Long id) {
        return candidateRepo.findCandidateById(id)
                .orElseThrow(() -> new UserNotFoundException("Candidate with email: '" + id + "' is not found."));
    }

    public void deleteCandidate(Long id) {
        candidateRepo.deleteCandidateById(id);
    }
}
