package com.faiz.bookestore.dao;

import com.faiz.bookestore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookDao extends CrudRepository<Book, Long> {
    List<Book> findByName(String name);
}

