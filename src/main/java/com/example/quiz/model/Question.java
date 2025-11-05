package com.example.quiz.model;

import lombok.Data;

/**
 * Phase 1: 問題モデル
 */
@Data
public class Question {
    private Integer id;
    private String text;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    
    // ========================================
    // Phase 2: カテゴリ情報追加
    // ========================================
    
    /**
     * カテゴリID
     * 
     * Phase 2で使用
     */
    // private Integer categoryId;
    
    /**
     * カテゴリ名（JOIN時に取得）
     * 
     * Phase 2で使用
     */
    // private String categoryName;
}