package com.faiz.bookestore.web;

import com.faiz.bookestore.exception.NoDataFoundException;
import com.faiz.bookestore.model.Book;
import com.faiz.bookestore.model.GetTotalPriceReq;
import com.faiz.bookestore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    //@Autowired
    private final BookService bookService;

    @RequestMapping(value = "/api/v1/books", method = RequestMethod.GET)
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) bookService.findAll();
    }

    @RequestMapping(value = "/api/v1/book/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Book findBookRest(@PathVariable("id") long bookId) {
        return bookService.findById(bookId);
    }

    @RequestMapping(value = "/api/v1/book/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book book) {
        Book oldBook = bookService.findById(id);

        if (oldBook == null) {
            throw new NoDataFoundException();
            //return new ResponseEntity<Book>(HttpStatus.NOT_FOUND); //or throw new NoDataFoundException();
        }
        if (StringUtils.isNotBlank(book.getAuthor())) {
            oldBook.setAuthor(book.getAuthor());
        }
        if (StringUtils.isNotBlank(book.getDescription())) {
            oldBook.setDescription(book.getDescription());
        }
        if (StringUtils.isNotBlank(book.getType())) {
            oldBook.setType(book.getType());
        }
        if (book.getIsbn() != 0) {
            oldBook.setIsbn(book.getIsbn());
        }
        if (book.getPrice() != 0.0) {
            oldBook.setPrice(book.getPrice());
        }
        if (StringUtils.isNotBlank(book.getName())) {
            oldBook.setName(book.getName());
        }

        bookService.update(oldBook);
        return new ResponseEntity<Book>(oldBook, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/book/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable int id) {

        Book existingBook = bookService.findById(id);
        if (existingBook == null) {
            throw new NoDataFoundException();
            //return new ResponseEntity<Book>(HttpStatus.NOT_FOUND); //or throw new NoDataFoundException();
        }
        bookService.delete(id);
        return new ResponseEntity<String>("Record deleted Successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/book", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return new ResponseEntity<Book>(bookService.save(book), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/book/getTotalPrice", method = RequestMethod.POST)
    public ResponseEntity<Double> getTotalPrice(@RequestBody GetTotalPriceReq getTotalPriceRequest) {
        return new ResponseEntity<Double>(bookService.getTotalPrice(getTotalPriceRequest.getBooksName()), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/book/getDiscountedTotalPrice", method = RequestMethod.POST)
    public ResponseEntity<Double> getDiscountedTotalPrice(@RequestBody GetTotalPriceReq getTotalPriceRequest) {
        return new ResponseEntity<Double>(bookService.getDiscountedPrice(getTotalPriceRequest.getBooksName(),getTotalPriceRequest.getPromoCode()), HttpStatus.OK);
    }

}
