package com.example.dyb.controller;

import com.example.dyb.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionController {
   @ExceptionHandler(value = BookNotFoundException.class)
        public ResponseEntity<Object> exception(BookNotFoundException exception) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }
    }

