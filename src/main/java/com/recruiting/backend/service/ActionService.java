package com.recruiting.backend.service;

import com.recruiting.backend.exception.ActionNotFoundException;
import com.recruiting.backend.model.Action;
import com.recruiting.backend.repo.ActionRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ActionService {
    private final ActionRepo actionRepo;

    public ActionService(ActionRepo actionRepo) {
        this.actionRepo = actionRepo;
    }

    public Action addAction(Action action) {
        return actionRepo.save(action);
    }

    public Action findActionById(Long id) {
        return actionRepo.findActionById(id)
                .orElseThrow(() -> new ActionNotFoundException("Action with id " + id + " was not found"));
    }

    public List<Action> findActionsByCandidateId(Long candidateId) {
        return actionRepo.findActionsByCandidateId(candidateId, Sort.by(Sort.Direction.ASC, "date"))
                .orElseThrow(() -> new ActionNotFoundException("Candidate with id " + candidateId + " has no actions"));
    }

    public void deleteActionById(Long id) {
        actionRepo.deleteActionById(id);
    }

    public void deleteActionsByCandidateId(Long candidateId) {
        actionRepo.deleteActionsByCandidateId(candidateId);
    }
}
