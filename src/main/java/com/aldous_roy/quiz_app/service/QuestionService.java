package com.aldous_roy.quiz_app.service;

import com.aldous_roy.quiz_app.Question;
import com.aldous_roy.quiz_app.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private  QuestionDao questionDao;

    public  List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getTypeQuestions(String difficulty) {
        return questionDao.findByDifficultyLevel(difficulty);
    }

    public List<Question> getPaginatedQuestions(int page, int size) {
        return questionDao.findAll(org.springframework.data.domain.PageRequest.of(page, size)).getContent();
    }

    public void saveQuestion(Question question) {
        questionDao.save(question);
    }

    public void saveAllQuestions(List<Question> questions) {
        questionDao.saveAll(questions);
    }
}