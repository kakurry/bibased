package com.example.bibased;

import com.example.bibased.mongDBdao.AuthorRepository;
import com.example.bibased.mongDBdao.BookRepository;
import com.example.bibased.mongDBdao.CustomerRepository;
import com.example.bibased.mongDBjavabean.Author;
import com.example.bibased.mongDBjavabean.Book;
import com.example.bibased.mongDBjavabean.Customer;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBtests {
    @Autowired
    private  CustomerRepository repository;

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    /**
     * 单表查询测试
     * @throws Exception
     */
    @Test
    public void  MongoDBtest()  throws Exception {
        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("查询出这个MongoDB的MyMongoDB库的Customer表的所有数据：");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("查询出这个MongoDB的MyMongoDB库的Customer表的firstName = Alice 数据：");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("查询出这个MongoDB的MyMongoDB库的Customer表的lastName = Smith 数据：");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }

    /**
     *    表     关      联
     * 多表MongoDB连接测试
     * @throws Exception
     */
    @Test
    public void DoubleMongoDB() throws Exception{
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        Book ci = new Book("Continous Integration", LocalDate.now());
        bookRepository.save(ci);
        Book c2 = new Book("Java编程思想", LocalDate.now());
        Book c3 = new Book("Java核心技术", LocalDate.now());
        Book c4 = new Book("Effective Java", LocalDate.now());
        Book c5 = new Book("深入理解虚拟机", LocalDate.now());
        Book c6 = new Book("深入理解虚拟机", LocalDate.now());
        bookRepository.save(c2);
        bookRepository.save(c3);
        bookRepository.save(c4);
        bookRepository.save(c5);
        bookRepository.save(c6);

        List<Book> books = bookRepository.findAll();
        System.out.println("输出所有的书的数据：");
        System.out.println(books);

        Author julius = new Author("Julius",Stream.of(ci, c2, c3, c4, c5, c6).collect(Collectors.toSet()));
        authorRepository.save(julius);
        System.out.println("输出所有作者的数据：");
        System.out.println(authorRepository.findAll());
    }

}
