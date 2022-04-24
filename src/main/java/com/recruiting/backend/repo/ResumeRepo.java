package com.recruiting.backend.repo;
import com.recruiting.backend.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Long> {
    void deleteResumeById(Long id);
    void deleteResumeByCandidateId(Long candidateId);
    Optional<Resume> findResumeById(Long id);
}
