package com.example.user_auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateUserResponse {

    private UUID id;

    private String email;
}
