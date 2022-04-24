package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Candidate;
import com.recruiting.backend.repo.CandidateRepo;
import com.recruiting.backend.repo.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return candidateRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public Candidate findCandidateById(Long id) {
        return candidateRepo.findCandidateById(id)
                .orElseThrow(() -> new UserNotFoundException("Candidate with email: '" + id + "' is not found."));
    }

    public List<Candidate> findCandidatesByJobPositionId(Long jobPositionId) {
        return candidateRepo.findCandidatesByJobPositionId(jobPositionId)
                .orElseThrow(() -> new UserNotFoundException("Candidate not found for job position"));
    }

    public void deleteCandidate(Long id) {
        candidateRepo.deleteCandidateById(id);
    }

    public void deleteCandidatesByJobPositionId(Long jobPositionId) {
        candidateRepo.deleteCandidatesByJobPositionId(jobPositionId);
    }
}
