package com.enigmacamp.mandiri.goldmarket.repositories;

import com.enigmacamp.mandiri.goldmarket.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRole(String role);
}
