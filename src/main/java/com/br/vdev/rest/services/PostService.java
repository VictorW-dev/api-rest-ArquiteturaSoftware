package com.br.vdev.rest.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.vdev.rest.domain.Post;
import com.br.vdev.rest.repository.PostRepository;
import com.br.vdev.rest.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		
		// CONSULTA SIMPLES COM QUERY METHODS
		return repo.findByTitleContainingIgnoreCase(text);
		
		// CONSULTA SIMPLES COM @QUERY
		//return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		
		return repo.fullSearch(text, minDate, maxDate);
	}

}
