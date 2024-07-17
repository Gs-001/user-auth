package com.example.user_auth.service;

import com.example.user_auth.dto.CreateUserRequest;
import com.example.user_auth.entity.CustomUser;
import com.example.user_auth.entity.Role;
import com.example.user_auth.mapper.CustomUserMapper;
import com.example.user_auth.repository.CustomUserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserService {

    CustomUserRepository customUserRepository;

    public CustomUserService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    public CustomUser createUser(CreateUserRequest  createUserRequest, Role role) {
        List<CustomUser> userSearch = customUserRepository.findByEmail(createUserRequest.getEmail());
        if (!userSearch.isEmpty()) {
//            Throw exception
        }
        CustomUser user = Mappers.getMapper(CustomUserMapper.class)
                .createUserRequestToCustomUser(createUserRequest);
        user.setRoles(Collections.singletonList(role));
        customUserRepository.save(user);
        return user;
    }
}
