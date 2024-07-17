package com.example.user_auth.mapper;

import com.example.user_auth.dto.CreateUserRequest;
import com.example.user_auth.entity.CustomUser;
import org.mapstruct.Mapper;

@Mapper
public interface CustomUserMapper {

    CustomUser createUserRequestToCustomUser(CreateUserRequest createUserRequest);
}
