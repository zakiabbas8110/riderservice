package com.beta.riderservice.exception;

public class RiderNotFoundException extends RuntimeException {

    public RiderNotFoundException() {
        super();
    }

    public RiderNotFoundException(String message) {
        super(message);
    }
}