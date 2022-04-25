package com.recruiting.backend.controller;
import java.io.IOException;

import com.recruiting.backend.model.Resume;
import com.recruiting.backend.service.ResumeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping(path= "/add", consumes = {MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Resume> addResume(@RequestParam("resume") MultipartFile file, @RequestParam("id") Long id)
            throws IOException {
        Resume resume = resumeService.addResume(file, id);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<byte[]> findResumeById(@RequestParam("id") Long id) {
        Resume resume = resumeService.findResumeById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resume.getName() + "\"")
                .body(resume.getData());
    }

    @Transactional
    @PostMapping("/delete")
    public ResponseEntity<?> deleteResume(@RequestParam("id") Long id) {
        resumeService.deleteResumeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
