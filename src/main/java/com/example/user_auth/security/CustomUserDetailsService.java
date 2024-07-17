package com.example.user_auth.security;

import com.example.user_auth.entity.CustomUser;
import com.example.user_auth.entity.Role;
import com.example.user_auth.repository.CustomUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    CustomUserRepository customUserRepository;

    public CustomUserDetailsService(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<CustomUser> userResults = customUserRepository.findByEmail(email);
        if (userResults.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        CustomUser user = userResults.get(0);
        return new User(user.getEmail(), user.getPassword(), getAuthoritiesFromRoles(user.getRoles()));
    }

    List<SimpleGrantedAuthority> getAuthoritiesFromRoles(List<Role> roles) {
        List<SimpleGrantedAuthority> authorities = roles.stream()
                .map((role) -> {return new SimpleGrantedAuthority(role.toString());})
                .collect(Collectors.toList());
        return authorities;
    }
}
