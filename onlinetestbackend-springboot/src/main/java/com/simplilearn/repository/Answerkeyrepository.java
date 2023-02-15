package com.simplilearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.Answerkey;

@Repository
public interface Answerkeyrepository extends JpaRepository<Answerkey, Integer>{

}
