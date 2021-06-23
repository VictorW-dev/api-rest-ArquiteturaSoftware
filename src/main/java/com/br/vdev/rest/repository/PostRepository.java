package com.br.vdev.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.vdev.rest.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	/* CONSULTA SIMPLES COM @QUERY
	 * @Query("{ <field>: { $regex: /pattern/, $options: '<options>' } }")
	 * @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	 * List<Post> findByTitle(String text);
	*/

	// CONSULTA SIMPLES COM QUERY METHODS
	List<Post> findByTitleContainingIgnoreCase(String text);

}
