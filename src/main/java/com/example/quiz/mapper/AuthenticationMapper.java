package com.example.quiz.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.quiz.model.Authentication;

@Mapper
public interface AuthenticationMapper {
    Authentication selectByUsername(String username);
}