package com.example.bibased.mongDBdao;

import com.example.bibased.mongDBjavabean.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

}
