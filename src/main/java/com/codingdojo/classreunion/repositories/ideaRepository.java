package com.codingdojo.classreunion.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.classreunion.models.Idea;

@Repository
public interface ideaRepository extends CrudRepository<Idea, Long>{

	List<Idea> findAll();
	
}
