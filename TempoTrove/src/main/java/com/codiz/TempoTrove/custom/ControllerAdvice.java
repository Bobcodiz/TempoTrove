package com.codiz.TempoTrove.custom;

import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public EntityAlreadyExistException handeUserAlreadyExistException
            (EntityAlreadyExistException e)
    {
        return new EntityAlreadyExistException(e.getMessage());
    }
    @ExceptionHandler
    public IncorrectFormatExceptions handeIncorrectFormatExceptions
            (IncorrectFormatExceptions e)
    {
        return new IncorrectFormatExceptions(e.getMessage());
    }
}
