package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Applicant;
import com.recruiting.backend.repo.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final ApplicantRepo applicantRepo;

    @Autowired
    public ApplicantService(ApplicantRepo applicantRepo) {
        this.applicantRepo = applicantRepo;
    }

    public Applicant addApplicant(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public List<Applicant> findAllApplicants() {
        return applicantRepo.findAll();
    }

    public Applicant updateApplicant(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public Applicant findApplicantById(Long id) {
        return applicantRepo.findApplicantById(id)
                .orElseThrow(() -> new UserNotFoundException("Applicant with email: '" + id + "' is not found."));
    }

    public void deleteApplicant(Long id) {
        applicantRepo.deleteApplicantById(id);
    }
}
