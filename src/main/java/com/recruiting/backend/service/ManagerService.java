package com.recruiting.backend.service;

import com.recruiting.backend.exception.UserNotFoundException;
import com.recruiting.backend.model.Manager;
import com.recruiting.backend.repo.ManagerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepo managerRepo;

    @Autowired
    public ManagerService(ManagerRepo managerRepo) { this.managerRepo = managerRepo; }

    public Manager addManager(Manager manager) { return managerRepo.save(manager); }

    public List<Manager> findAllManagers() {
        return managerRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Manager updateManager(Manager manager) { return managerRepo.save(manager); }

    public Manager findManagerById(Long id) {
        return managerRepo.findManagerById(id)
                .orElseThrow(() -> new UserNotFoundException("Manager with id: " + id + " is not found."));
    }

    public void deleteManager(Long id) { managerRepo.deleteManagerById(id); }

}
