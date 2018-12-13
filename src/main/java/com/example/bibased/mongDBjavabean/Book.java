package com.example.bibased.mongDBjavabean;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDate;


/*@Field指定数据库映射的字段
@Transient标注的字段则不会映射到db
@Document(collection = "books")可以指定集合名称，如果不指定则是类名首字母小写*/

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String title;
    @Field("published")
    private LocalDate publicationDate;

    // No args Constructor
    public Book(String title, LocalDate publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

}