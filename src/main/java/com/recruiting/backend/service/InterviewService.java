package com.recruiting.backend.service;

import com.recruiting.backend.exception.InterviewNotFoundException;
import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Interview;
import com.recruiting.backend.repo.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    private final InterviewRepo interviewRepo;

    @Autowired
    public InterviewService(InterviewRepo interviewRepo) { this.interviewRepo = interviewRepo; }

    public Interview addInterview(Interview interview) { return interviewRepo.save(interview); }

    public List<Interview> findAllInterviews() { return interviewRepo.findAll(Sort.by(Sort.Direction.ASC, "dateTime")); }

    public Interview updateInterview(Interview interview) { return interviewRepo.save(interview); }

    public Interview findInterviewById(Long id) {
        return interviewRepo.findInterviewById(id)
                .orElseThrow(() -> new InterviewNotFoundException("Interview with id: '" + id + "' not found."));
    }

    public List<Interview> findInterviewsByCandidateId(Long candidateId) {
        return interviewRepo.findInterviewsByCandidateId(candidateId)
                .orElseThrow(() -> new UserNotFoundException("Candidate with id: " + candidateId + " is not found"));
    }

    public List<Interview> findInterviewsByManagerId(Long managerId) {
        return interviewRepo.findInterviewsByManagerId(managerId)
                .orElseThrow(() -> new UserNotFoundException("Manager with id: " + managerId + " is not found."));
    }

    public void deleteInterviewsByCandidateId(Long candidateId) {
        interviewRepo.deleteInterviewsByCandidateId(candidateId);
    }

    public void deleteInterviewsByManagerId(Long managerId) {
        interviewRepo.deleteInterviewsByManagerId(managerId);
    }

    public void deleteInterview(Long id) { interviewRepo.deleteInterviewById(id); }
}
