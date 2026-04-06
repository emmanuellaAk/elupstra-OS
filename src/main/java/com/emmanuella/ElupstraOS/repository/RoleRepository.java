package com.emmanuella.ElupstraOS.repository;

import com.emmanuella.ElupstraOS.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findByIsActive(Boolean isActive);
    Optional<Role> findByName(String name);
}
