package com.example.quiz.model;

import lombok.Data;

@Data
public class Result {
    private String userName;
    private Integer correct;
    private Integer total;
}
