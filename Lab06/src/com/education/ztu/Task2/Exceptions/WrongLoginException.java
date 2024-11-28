package com.education.ztu.Task2.Exceptions;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException(){
        super("Wrong login.");
    }
    public WrongLoginException(String message) {
        super(message);
    }
}
