package com.example.bibased.mongDBdao;

import com.example.bibased.mongDBjavabean.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, ObjectId> {

}