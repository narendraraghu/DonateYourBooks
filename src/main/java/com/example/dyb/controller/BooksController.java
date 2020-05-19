package com.example.dyb.controller;

import com.example.dyb.exception.BookNotFoundException;
import com.example.dyb.exception.UserNotFoundException;
import com.example.dyb.services.BooksService;
import com.example.dyb.model.Books;
import com.example.dyb.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.Objects.*;

@RestController
@RequestMapping("/api/")
public class BooksController {
    //autowire the BooksService class
    @Autowired
    BooksService booksService;

    @Autowired
    ValidationService validationService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@Valid @PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) throws UserNotFoundException {
        try {
            booksService.delete(bookid);
        } catch (Exception e) {
            throw new BookNotFoundException();
        }
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private ResponseEntity<?> saveBook(@Valid @RequestBody Books books, BindingResult bindingResult) {

        ResponseEntity<?> errorMap = validationService.getValidationErrorsMap(bindingResult) ;
        if(errorMap!=null)
            return validationService.getValidationErrorsMap(bindingResult);

        Books books1 = booksService.saveOrUpdate(books);
        return new ResponseEntity<>(books1, HttpStatus.CREATED);
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }
}
