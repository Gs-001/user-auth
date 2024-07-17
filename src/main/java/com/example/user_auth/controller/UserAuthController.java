package com.example.user_auth.controller;

import com.example.user_auth.dto.CreateUserRequest;
import com.example.user_auth.dto.CreateUserResponse;
import com.example.user_auth.entity.CustomUser;
import com.example.user_auth.entity.Role;
import com.example.user_auth.mapper.CustomUserMapper;
import com.example.user_auth.repository.CustomUserRepository;
import com.example.user_auth.service.CustomUserService;
import org.apache.coyote.Response;
import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserAuthController {

    CustomUserService customUserService;

    public UserAuthController(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @GetMapping("/test/1")
    public String testApi() {
        return "Test API 1";
    }

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> createUserStudent(
                                                @RequestBody CreateUserRequest createUserRequest) {

        CustomUser user = customUserService.createUser(createUserRequest, Role.STUDENT);
        return ResponseEntity.ok(new CreateUserResponse(user.getId(), user.getEmail()));
    }

    @PostMapping("/signup/admin")
    public ResponseEntity<CreateUserResponse> createUserAdmin(@RequestBody CreateUserRequest createUserRequest) {
        CustomUser user = customUserService.createUser(createUserRequest, Role.ADMIN);
        return ResponseEntity.ok(new CreateUserResponse(user.getId(), user.getEmail()));
    }

    @PostMapping("/signup/instructor")
    public ResponseEntity<CreateUserResponse> createUserInstructor(@RequestBody CreateUserRequest createUserRequest) {
        CustomUser user = customUserService.createUser(createUserRequest, Role.INSTRUCTOR);
        return ResponseEntity.ok(new CreateUserResponse(user.getId(), user.getEmail()));
    }

}
