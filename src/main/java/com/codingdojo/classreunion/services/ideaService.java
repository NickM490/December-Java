package com.codingdojo.classreunion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.classreunion.models.Idea;
import com.codingdojo.classreunion.repositories.ideaRepository;

@Service
public class ideaService {

	@Autowired
	ideaRepository ideaRepo;
	
	// See all the ideas
	public List<Idea> allIdeas() {
		return ideaRepo.findAll();
	}
	
	
	// Create an idea
	public Idea create(Idea idea) {
		return ideaRepo.save(idea);
	}
	
	
	// Find one idea
	public Idea oneIdea(Long id) {
		Optional<Idea> optionalIdea = ideaRepo.findById(id);
		if(optionalIdea.isPresent()) {
			return optionalIdea.get();
		}
		else {
			return null;
		}
		
		
	}
	
	
	// Delete the idea
	public void deleteIdea(Long id) {
		ideaRepo.deleteById(id);
	}
	
	
	// Update an idea
	public Idea updateIdea(Idea idea) {
		return ideaRepo.save(idea);
	}
	
	
}
