package com.example.user_auth.init;

import com.example.user_auth.entity.CustomUser;
import com.example.user_auth.entity.Role;
import com.example.user_auth.repository.CustomUserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SqlInit implements ApplicationRunner {

    CustomUserRepository customUserRepository;

    PasswordEncoder passwordEncoder;

    SqlInit(CustomUserRepository customUserRepository, PasswordEncoder passwordEncoder) {
        this.customUserRepository = customUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private void createCustomUsers() {
        List<String> userEmails = new ArrayList<>();
        userEmails.add("gs_student@gmail.com");
        userEmails.add("gs_instructor@gmail.com");
        userEmails.add("gs_admin@gmail.com");

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(Role.STUDENT);
        userRoles.add(Role.INSTRUCTOR);
        userRoles.add(Role.ADMIN);

        int i = 2;
        while(i >= 0){
            customUserRepository.save(new CustomUser(userEmails.get(i),
                    passwordEncoder.encode("password"),
                    Collections.singletonList(userRoles.get(i))));

            i -= 1;
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("SQL INIT");
        createCustomUsers();
        System.out.println("COMPLETED SQL INIT");
    }
}
