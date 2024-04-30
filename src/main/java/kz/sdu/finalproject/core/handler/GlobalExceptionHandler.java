package kz.sdu.finalproject.core.handler;

import kz.sdu.finalproject.core.dto.ErrorResponse;
import kz.sdu.finalproject.core.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = UserNotFoundException.class)
    public ErrorResponse userNotFoundHandler(UserNotFoundException ex){
        return new ErrorResponse(LocalDateTime.now(),ex.getMessage(), 400);
    }

}
