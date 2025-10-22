package com.melissza.readlog.repository;

import com.melissza.readlog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Keresés username alapján
    Optional<User> findByUsername(String username);

    // Keresés email alapján
    Optional<User> findByEmail(String email);

    // Létezik-e már ilyen username
    boolean existsByUsername(String username);

    // Létezik-e már ilyen email
    boolean existsByEmail(String email);
}