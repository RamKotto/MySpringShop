package ru.saraev.myspringshop.exceptions;

public class ResourceNotFountException extends RuntimeException {

    public ResourceNotFountException(String message) {
        super(message);
    }
}
