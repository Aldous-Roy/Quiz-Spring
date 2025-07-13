package com.aldous_roy.quiz_app.controller;

import com.aldous_roy.quiz_app.Question;
import com.aldous_roy.quiz_app.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @GetMapping("/paginated")
    public List<Question> getPaginatedQuestions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        return questionService.getPaginatedQuestions(page, size);
    }

    @GetMapping("/type/{difficulty}")
    public List<Question> getEasyQuestions(@PathVariable String difficulty) {
        return questionService.getTypeQuestions(difficulty);
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question) {
        questionService.saveQuestion(question);
        return "Question saved successfully!";
    }
    @PostMapping("/addAll")
    public String addMultipleQuestions(@RequestBody List<Question> questions) {
        questionService.saveAllQuestions(questions);
        return "Questions saved successfully!";
    }
}
