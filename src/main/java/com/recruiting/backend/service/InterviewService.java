package com.recruiting.backend.service;

import com.recruiting.backend.exception.InterviewNotFoundException;
import com.recruiting.backend.model.Interview;
import com.recruiting.backend.repo.InterviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    private final InterviewRepo interviewRepo;

    @Autowired
    public InterviewService(InterviewRepo interviewRepo) { this.interviewRepo = interviewRepo; }

    public Interview addInterview(Interview interview) { return interviewRepo.save(interview); }

    public List<Interview> findAllInterviews() { return interviewRepo.findAll(); }

    public Interview updateInterview(Interview interview) { return interviewRepo.save(interview); }

    public Interview findInterviewById(Long id) {
        return interviewRepo.findInterviewById(id)
                .orElseThrow(() -> new InterviewNotFoundException("Interview with id: '" + id + "' not found."));
    }

    public void deleteInterview(Long id) { interviewRepo.deleteInterviewById(id); }
}
