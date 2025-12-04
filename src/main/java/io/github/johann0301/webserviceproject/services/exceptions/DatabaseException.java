package io.github.johann0301.webserviceproject.services.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseException(String message){
        super(message);
    }
}
