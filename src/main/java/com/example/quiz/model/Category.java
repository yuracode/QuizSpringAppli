package com.example.quiz.model;

import lombok.Data;

/**
 * Phase 2: カテゴリモデル
 * 
 * categoriesテーブルに対応
 */
@Data
public class Category {
    private Integer id;
    private String name;
}