package org.bolshakovk.registrationServer.repositories;

import org.bolshakovk.registrationServer.models.Role;
import org.bolshakovk.registrationServer.utils.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAll();
    Optional<Role> findByName(ERole name);
}
