package com.example.quiz.mapper;

import com.example.quiz.model.Category;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * Phase 2: カテゴリマッパー
 */
@Mapper
public interface CategoryMapper {
    /** 全カテゴリ取得 */
    List<Category> findAll();
    /** IDでカテゴリ取得 */
    Category findById(Integer id);
}
