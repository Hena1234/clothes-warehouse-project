package com.example.clotheswarehouse.model.form;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.clotheswarehouse.model.User;

import lombok.Data;

@Data
public class RegistrationForm {
    private String username;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();
    }

}
