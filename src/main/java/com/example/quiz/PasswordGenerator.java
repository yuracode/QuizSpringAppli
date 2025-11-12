package com.example.quiz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String hashed = encoder.encode(password);
        System.out.println("新しいハッシュ値: " + hashed);
    }
}