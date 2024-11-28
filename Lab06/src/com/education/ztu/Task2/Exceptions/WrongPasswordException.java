package com.education.ztu.Task2.Exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(){
        super("Wrong password.");
    }
    public WrongPasswordException(String message) {
        super(message);
    }
}
