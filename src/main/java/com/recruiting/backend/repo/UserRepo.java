package com.recruiting.backend.repo;

import com.recruiting.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    void deleteUserById(Long id);
    void deleteUserByUsername(String username);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
}
