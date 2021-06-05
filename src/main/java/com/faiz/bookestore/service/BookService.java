package com.faiz.bookestore.service;

import com.faiz.bookestore.model.Book;

import java.util.List;

public interface BookService {

    Book findById(long id);

    List<Book> findAll();

    Book save(Book book);

    void delete(long id);

    Book update(Book userDto);

    Double getTotalPrice(List<String> books);

    Double getDiscountedPrice(List<String> books, String promoCode);
}
