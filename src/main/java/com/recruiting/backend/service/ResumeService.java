package com.recruiting.backend.service;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Resume;
import com.recruiting.backend.repo.ResumeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ResumeService {
    private final ResumeRepo resumeRepo;

    @Autowired
    public ResumeService(ResumeRepo resumeRepo) { this.resumeRepo = resumeRepo; }

    public Resume addResume(MultipartFile file, Long id) throws IOException {
        String resumeName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Resume resume = new Resume(id, resumeName, file.getContentType(), file.getBytes());
        return resumeRepo.save(resume);
    }

    public Resume findResumeById(Long id) {
        return resumeRepo.findResumeById(id).orElseThrow(
                () -> new UserNotFoundException("Resume with id: " + id + " is not found.")
        );
    }

    public void deleteResumeById(Long id) {
        resumeRepo.deleteResumeById(id);
    }

}
