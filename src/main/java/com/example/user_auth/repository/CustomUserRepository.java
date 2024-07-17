package com.example.user_auth.repository;

import com.example.user_auth.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser, UUID> {

    List<CustomUser> findByEmail(String email);
}
