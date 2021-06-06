package com.faiz.bookestore.web;

import com.faiz.bookestore.config.PromoProperties;
import com.faiz.bookestore.dao.BookDao;
import com.faiz.bookestore.exception.BookAlreadyExistException;
import com.faiz.bookestore.exception.NoDataFoundException;
import com.faiz.bookestore.exception.RequestPayloadException;
import com.faiz.bookestore.model.Book;
import com.faiz.bookestore.service.BookService;
import com.faiz.bookestore.service.impl.BookServiceImpl;
import io.qameta.allure.Feature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@Slf4j
@DisplayName("Unit Tests - BookController Unit Tests")
@Feature("Unit Tests - BookController Unit Tests")
public class BookControllerTest {

    PromoProperties promoProperties = new PromoProperties();

    @InjectMocks
    private BookService bookService = new BookServiceImpl(promoProperties);
    //@Mock
    private BookController bookController = new BookController(bookService);

    @Mock
    private BookDao bookDao;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        bookService = mock(BookServiceImpl.class);
        when(bookService.findAll())
                .thenReturn(new ArrayList<>());

        Book book = Book.builder()
                .id(1L)
                .author("Faiz")
                .name("fdsafdf")
                .price(10.0)
                .description("dsasda adasd")
                .type("asdsadsad")
                .isbn(2)
                .build();

        when(bookDao.findById(anyLong())).thenReturn(Optional.of(book));
        when(bookDao.save(book)).thenReturn(book);
    }

    @Test
    public void bookListRestTest() {
        when(bookDao.findAll()).thenReturn(Arrays.asList(new Book()));
        assertNotNull(bookController.bookListRest());
    }

    @Test
    public void bookListRestExceptionTest() {
        when(bookService.findAll())
                .thenReturn(Arrays.asList());

        Exception exception = assertThrows(NoDataFoundException.class, () -> {
            bookController.bookListRest();
        });

        String expectedMessage = "No data found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void findBookRestTest() {

        when(bookService.findById(anyInt()))
                .thenReturn(Book.builder()
                        .author("Faiz")
                        .name("fdsafdf")
                        .price(10.0)
                        .build()
                );

        assertNotNull(bookController.findBookRest(anyInt()));
    }

    @Test
    public void updateTest() {
        assertNotNull(bookController.update(anyInt(), Book.builder()
                .name("data")
                .build()));
    }

    @Test
    public void updateExceptionTest() {

        when(bookDao.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(NoDataFoundException.class, () -> {
            bookController.update(anyInt(), new Book());
        });

        String expectedMessage = "No data found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void deleteTest() {
        assertNotNull(bookController.delete(anyInt()));
    }

    @Test
    public void deleteExceptionTest() {

        when(bookDao.findById(anyLong())).thenReturn(Optional.empty());
        Exception exception = assertThrows(NoDataFoundException.class, () -> {
            bookController.delete(anyInt());
        });

        String expectedMessage = "No data found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void addBookTest(){
        when(bookDao.findById(anyLong())).thenReturn(Optional.empty());
        when(bookDao.save(any())).thenReturn(Book.builder().build());

        assertNotNull(bookController.addBook(Book.builder()
                .name("data")
                .build()));

    }

    @Test
    public void addBookSameDataExceptionTest() {

        when(bookDao.findById(anyLong())).thenReturn(Optional.of(new Book()));
        Exception exception = assertThrows(BookAlreadyExistException.class, () -> {
            bookController.addBook(Book.builder()
                    .name("data")
                    .build());
        });

        String expectedMessage = "Same name book already exist";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void addBookPayloadEmptyExceptionTest() {

        when(bookDao.findById(anyLong())).thenReturn(Optional.of(new Book()));
        Exception exception = assertThrows(RequestPayloadException.class, () -> {
            bookController.addBook(Book.builder()
                    .build());
        });

        String expectedMessage = "Payload is empty or book name is empty";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
