package com.simplilearn.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.model.Answer;
import com.simplilearn.model.Question;
import com.simplilearn.repository.Answerkeyrepository;
import com.simplilearn.repository.Answerrepository;
import com.simplilearn.repository.QuestionRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/questions/")
public class Questioncontroller {

	@Autowired
	private QuestionRepository questionrepository;
	
	@Autowired
	private Answerrepository answerrepository;
	
	
	
	@Autowired
	private Answerkeyrepository answerkeyrepository; 
	
	@Autowired
	EntityManager em;
	
	@GetMapping("/getquestions")
	public List<Question> getAllQuestions()
	{
		return questionrepository.findAll();
	}
	
	@GetMapping("/getanswers")
	public List<Answer> getAllAnswer()
	{
		
		return answerrepository.findAll(); 
	}
	
	@PostMapping("/postattempts")
	public void insertAnswer(@RequestBody Question[] question)
	{
		for(int i=0;i<question.length;i++)
		questionrepository.save(question[i]);
	}


	@GetMapping("/getresult")
    public List<Integer> getResult()
	{   
		List<Integer> result=new ArrayList<>();
		List<String> at=em.createQuery("select a.att from Question a").getResultList();
		List<String> ak=em.createQuery("select a.aKey from Answerkey a").getResultList();
        int total=ak.size();
		//int attempted=0;
		int wrong=0;
        String[] at1 = new String[at.size()];
        for (int i = 0; i < at.size(); i++)
            {
        	at1[i] = at.get(i);
        	if(at1[i]=="")
        		at1[i]="e";
        	
        		
            }
        String[] ak1 = new String[ak.size()];
        for (int i = 0; i < ak.size(); i++)
            ak1[i] = ak.get(i);
		
		int res=0;
		for(int i=0;i<at1.length;i++)
		{
		  if(at1[i].equals(ak1[i]))	
			  res++;
			
		}
		/* for (int i = 0; i < at1.length; i++)
         {
     	
     	   if(!(at1[i].contains("e")))
     	    attempted++;
     	
     		
         }*/
		
		wrong=total-res;
		result.add(0, total);
		//result.add(1, attempted);
		result.add(1,res);
		result.add(2, wrong);
		return result;
	}
	
	
	@PostMapping("/clearattempt")
	public void clearAttempts(@RequestBody Question[] question)
	{
	  for(int i=0;i<question.length;i++)
	  {
		  question[i].setAtt("");
		  questionrepository.save(question[i]);  
	  }
		
	}

}
