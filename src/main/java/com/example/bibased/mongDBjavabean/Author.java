package com.example.bibased.mongDBjavabean;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.persistence.Id;
import java.util.Set;

/**
 * @DBRef会引用books的表
    @Indexed(unique = true)设置索引，并且是唯一性索引

 */
@Data
public class Author {

    @Id
    private ObjectId id;
    @Indexed(unique = true)
    private String name;
    @DBRef
    private Set<Book> books;

    // No args Constructor
    public Author(String name,Set<Book> books) {
        this.name = name;
        this.books = books;
    }

}