package ru.saraev.myspringshop.exceptions;

public class ExistEntityException extends RuntimeException {

    public ExistEntityException(String message) {
        super(message);
    }
}
