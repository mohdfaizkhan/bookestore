package com.faiz.bookestore.web;

import com.faiz.bookestore.model.Book;
import com.faiz.bookestore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/api/v1/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) bookService.findAll();
    }

    @RequestMapping(value="/api/v1/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Book findBookRest(@PathVariable("id") long bookId) {
        return bookService.findById(bookId);
    }
}
