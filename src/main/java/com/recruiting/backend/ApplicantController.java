package com.recruiting.backend;

import com.recruiting.backend.model.Applicant;
import com.recruiting.backend.service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
    private final ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Applicant>> getAllApplicants() {
        List<Applicant> applicants = applicantService.findAllApplicants();
        return new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Applicant> getApplicantByEmail(@RequestParam("id") Long id) {
        Applicant applicant = applicantService.findApplicantById(id);
        return new ResponseEntity<>(applicant, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant) {
        Applicant newApplicant = applicantService.addApplicant(applicant);
        return new ResponseEntity<>(newApplicant, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Applicant> updateApplicant(@RequestBody Applicant applicant) {
        Applicant updatedApplicant = applicantService.updateApplicant(applicant);
        return new ResponseEntity<>(updatedApplicant, HttpStatus.OK);
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteApplicant(@RequestParam("id") Long id) {
        applicantService.deleteApplicant(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
