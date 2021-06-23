package com.br.vdev.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.vdev.rest.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}