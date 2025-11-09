package com.example.quiz.mapper;

import com.example.quiz.model.Category;
import com.example.quiz.model.CategoryWithCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> findAll();
    
    List<CategoryWithCount> findAllWithQuestionCount();
}