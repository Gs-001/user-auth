package com.example.user_auth.dto;

import lombok.Data;

@Data
public class CreateUserRequest {

    private String email;

    private String password;
}
