package com.br.vdev.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.vdev.rest.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
