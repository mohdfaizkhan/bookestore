package com.faiz.bookestore.exception;

public class BookAlreadyExistException extends RuntimeException {

    public BookAlreadyExistException() {

        super("Same name book already exist");
    }
}
