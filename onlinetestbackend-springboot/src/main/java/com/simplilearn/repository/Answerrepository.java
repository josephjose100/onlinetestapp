package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.Answer;

@Repository
public interface Answerrepository extends JpaRepository<Answer, Integer> {
	
	

}
