package com.example.quiz.mapper;

import com.example.quiz.model.Question;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Phase 1: 問題マッパー
 */
@Mapper
public interface QuestionMapper {
    
    /**
     * 全問題を取得
     */
    List<Question> findAll();
    
    /**
     * IDで問題を取得
     */
    Question findById(Integer id);
    
    // ========================================
    // Phase 2: カテゴリ別問題取得
    // ========================================
    
    /**
     * カテゴリIDで問題を取得
     * 
     * TODO Phase 2: QuestionMapper.xmlにSELECT文を追加
     */
    List<Question> findByCategoryId(Integer categoryId);
    
    /**
     * カテゴリ情報を含めて問題を取得（JOIN）
     * 
     * TODO Phase 2: JOINを使ったクエリを書く
     */
    // List<Question> findAllWithCategory();
}