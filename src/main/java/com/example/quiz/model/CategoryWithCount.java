package com.example.quiz.model;

import lombok.Data;

@Data
public class CategoryWithCount {
    private Integer id;
    private String name;
    private Integer questionCount;  // このカテゴリの問題数

}