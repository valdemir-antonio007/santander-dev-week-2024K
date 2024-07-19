package me.dio.domain.controller.exception;

import me.dio.domain.model.Bootcamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String>  handleIllegalException(IllegalArgumentException ilegalException){
        return new ResponseEntity<>(ilegalException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String>  handleNoSuchException(NoSuchElementException noSuchException){
        return new ResponseEntity<>( "Bootcamp not found" , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String>  handleUnexptedException(Throwable unexptedException){
        var message = "Unexpted error, see logs.";
        logger.error(message, unexptedException);
        return new ResponseEntity<>( message , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
