package org.bolshakovk.registrationServer.repositories;

import org.bolshakovk.registrationServer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmail(String userEmail);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
