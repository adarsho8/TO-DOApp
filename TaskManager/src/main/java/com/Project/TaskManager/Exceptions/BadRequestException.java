package com.Project.TaskManager.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message)
    {
        super(message);
    }
}
