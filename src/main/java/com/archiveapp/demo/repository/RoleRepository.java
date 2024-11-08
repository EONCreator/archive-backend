package com.archiveapp.demo.repository;

import com.archiveapp.demo.entity.ERole;
import com.archiveapp.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}