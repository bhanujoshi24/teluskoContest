package com.telusko.contest.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.contest.entity.Questions;
import com.telusko.contest.repository.QuestionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Questions createQuestion(Questions question) {
        // Perform any necessary validation or business logic
        // Save the question entity in the database
        return questionRepository.save(question);
    }

    public Questions getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Question not found"));
    }

    public Questions updateQuestion(Long id, Questions updatedQuestion) {
        Questions question = getQuestionById(id);
        // Perform any necessary validation or business logic
        // Update the question entity with the new values
        question.setQuestionText(updatedQuestion.getQuestionText());
        question.setOption1(updatedQuestion.getOption1());
        question.setOption2(updatedQuestion.getOption2());
        question.setOption3(updatedQuestion.getOption3());
        question.setOption4(updatedQuestion.getOption4());
        question.setCorrectOption(updatedQuestion.getCorrectOption());
        question.setTechnology(updatedQuestion.getTechnology());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Questions question = getQuestionById(id);
        // Perform any necessary validation or business logic
        questionRepository.delete(question);
    }

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }
}
