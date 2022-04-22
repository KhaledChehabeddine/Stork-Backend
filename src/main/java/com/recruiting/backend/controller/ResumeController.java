package com.recruiting.backend.controller;
import java.io.IOException;

import com.recruiting.backend.model.Resume;
import com.recruiting.backend.service.ResumeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;

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
        byte[] encodedFile = Base64.getEncoder().encode(file.getBytes());
        Resume resume = resumeService.addResume(encodedFile, id);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<byte[]> findResumeById(@RequestParam("id") Long id) {
        Resume resume = resumeService.findResumeById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .header(HttpHeaders.CONTENT_ENCODING, "utf-8")
                .body(resume.getData());
    }
}
