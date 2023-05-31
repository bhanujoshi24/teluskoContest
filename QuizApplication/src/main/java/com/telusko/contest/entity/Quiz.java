package com.telusko.contest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="quizzes")
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String quizName;

	@Column(nullable = false)
	private String technology;

//	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
//	private List<QuizQuestion> quizQuestions;
	@JsonIgnoreProperties("quiz") // Add this annotation
	@OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
	private List<QuizQuestion> quizQuestions;


	public Quiz(Long id, String quizName, String technology, List<QuizQuestion> quizQuestions) {
		super();
		this.id = id;
		this.quizName = quizName;
		this.technology = technology;
		this.quizQuestions = quizQuestions;
	}
	
	public Quiz(String quizName, String technology, List<QuizQuestion> quizQuestions) {
		super();
		this.quizName = quizName;
		this.technology = technology;
		this.quizQuestions = quizQuestions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuizName() {
		return quizName;
	}

	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public List<QuizQuestion> getQuizQuestions() {
		return quizQuestions;
	}

	public void setQuizQuestions(List<QuizQuestion> quizQuestions) {
		this.quizQuestions = quizQuestions;
	}

	public Quiz() {
		super();
	}

	// Constructors, getters, setters
}