package com.example.PracticeSpringSecurity.repository;

import com.example.PracticeSpringSecurity.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}