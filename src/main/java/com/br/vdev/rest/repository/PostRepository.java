package com.br.vdev.rest.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.br.vdev.rest.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	// CONSULTA SIMPLES COM @QUERY
	// @Query("{ <field>: { $regex: /pattern/, $options: '<options>' } }")
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text);

	// CONSULTA SIMPLES COM QUERY METHODS
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	// CONSULTA COM VÁRIOS CRITÉRIOS
	// @Query({ $and: [ { <expression1> }, { <expression2> } , ... , { <expressionN> } ] })
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
