package com.faiz.bookestore.service.impl;

import com.faiz.bookestore.dao.BookDao;
import com.faiz.bookestore.model.Book;
import com.faiz.bookestore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public Book findById(long id) {
        Optional<Book> optionalBook = bookDao.findById(id);
        return optionalBook.isPresent() ? optionalBook.get() : null;
    }

    @Override
    public List<Book> findByName(String name) {
        List<Book> bookList = bookDao.findByName(name);
        return bookList;
    }


    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Book save(Book book) {
        Book newBook = new Book();
        newBook.setName(book.getName());
        newBook.setDescription(book.getDescription());
        newBook.setAuthor(book.getAuthor());
        newBook.setType(book.getType());
        newBook.setPrice(book.getPrice());
        newBook.setIsbn(book.getIsbn());
        return bookDao.save(newBook);
    }

    @Override
    public void delete(long id) {
        bookDao.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        Book book1 = findById(book.getId());
        if(book1 != null) {
            bookDao.save(book);
        }
        return book;
    }


}
