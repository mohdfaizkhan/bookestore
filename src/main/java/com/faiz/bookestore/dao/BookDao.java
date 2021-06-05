package com.faiz.bookestore.dao;

import com.faiz.bookestore.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface BookDao extends CrudRepository<Book, Long> {

    Book findByName(String name);

    @Query("SELECT b FROM Book b WHERE b.name IN (:names)")
    List<Book> findByBookNames(@Param("names")List<String> names);

}

