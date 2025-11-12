package com.example.quiz.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.quiz.mapper.AuthenticationMapper;
import com.example.quiz.model.Authentication;

import lombok.RequiredArgsConstructor;

//@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    
    private final AuthenticationMapper mapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("★★★ loadUserByUsername called: " + username);
        
        Authentication auth = mapper.selectByUsername(username);
        
        System.out.println("★★★ DB result: " + auth);
        
        if (auth == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりません: " + username);
        }
        
        System.out.println("★★★ Password from DB: " + auth.getPassword());
        
        return User.builder()
            .username(auth.getUsername())
            .password(auth.getPassword())
            .roles("USER")
            .build();
    }
}