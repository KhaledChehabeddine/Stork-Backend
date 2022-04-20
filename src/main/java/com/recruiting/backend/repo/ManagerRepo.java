package com.recruiting.backend.repo;

import com.recruiting.backend.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long> {

    void deleteManagerById(Long id);

    Optional<Manager> findManagerById(Long id);

}
