package com.recruiting.backend.exception;

public class ActionNotFoundException extends RuntimeException{
    public ActionNotFoundException(String message) { super(message); }
}
