package com.aldous_roy.quiz_app.dao;

import com.aldous_roy.quiz_app.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findByDifficultyLevel(String difficultyLevel);
//    Page<Question> findAll(Pageable pageable);
}
