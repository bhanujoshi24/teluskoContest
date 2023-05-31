package com.telusko.contest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.contest.entity.Quiz;
import com.telusko.contest.entity.QuizQuestion;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
    // Custom methods for quiz question-related operations
	public List<QuizQuestion> findByQuiz(Quiz quiz);
}