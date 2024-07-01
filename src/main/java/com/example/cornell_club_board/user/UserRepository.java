package com.example.cornell_club_board.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long>{

    // Basically is finding student by email through straight up SQL
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    Optional<User> findUserById(Long id);
}