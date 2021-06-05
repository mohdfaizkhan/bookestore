package com.faiz.bookestore.exception;

public class RequestPayloadException extends RuntimeException {

    public RequestPayloadException() {

        super("Payload is empty or book name is empty");
    }
}
