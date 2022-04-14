package com.recruiting.backend.repo;

import com.recruiting.backend.model.Action;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActionRepo extends JpaRepository<Action, Long> {
    void deleteActionById(Long id);
    void deleteActionsByCandidateId(Long candidateId);
    Optional<Action> findActionById(Long id);
    Optional<List<Action>> findActionsByCandidateId(Long candidateId, Sort sort);
}
