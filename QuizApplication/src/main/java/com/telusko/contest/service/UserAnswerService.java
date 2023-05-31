package com.telusko.contest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.telusko.contest.entity.UserAnswers;
import com.telusko.contest.repository.UserAnswerRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserAnswerService {
	private final UserAnswerRepository userAnswerRepository;

	public UserAnswerService(UserAnswerRepository userAnswerRepository) {
		this.userAnswerRepository = userAnswerRepository;
	}

	public UserAnswers createUserAnswer(UserAnswers userAnswer) {
		// Perform any necessary validation or business logic
		// Save the userAnswer entity in the database
		return userAnswerRepository.save(userAnswer);
	}

	public UserAnswers getUserAnswerById(Long id) {
		return userAnswerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User Answer not found"));
	}

	public UserAnswers updateUserAnswer(Long id, UserAnswers updatedUserAnswer) {
		UserAnswers userAnswer = getUserAnswerById(id);
		// Perform any necessary validation or business logic
		// Update the userAnswer entity with the new values
		userAnswer.setUsers(updatedUserAnswer.getUsers());
		userAnswer.setQuestions(updatedUserAnswer.getQuestions());
		userAnswer.setSelectedOption(updatedUserAnswer.getSelectedOption());
		return userAnswerRepository.save(userAnswer);
	}

	public void deleteUserAnswer(Long id) {
		UserAnswers userAnswer = getUserAnswerById(id);
		// Perform any necessary validation or business logic
		userAnswerRepository.delete(userAnswer);
	}

	public List<UserAnswers> getAllUserAnswers() {
		return userAnswerRepository.findAll();
	}
}
		