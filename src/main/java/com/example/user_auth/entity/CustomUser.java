package com.example.user_auth.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class CustomUser {

    @Id
    UUID id = UUID.randomUUID();

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    List<Role> roles;

    public CustomUser(String email, String password, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
