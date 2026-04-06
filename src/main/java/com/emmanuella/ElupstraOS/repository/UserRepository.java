package com.emmanuella.ElupstraOS.repository;

import com.emmanuella.ElupstraOS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByIsActive(Boolean isActive);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
