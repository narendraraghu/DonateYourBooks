package com.example.dyb.controller;

import com.example.dyb.exception.BookNotFoundException;
import com.example.dyb.exception.UserNotFoundException;
import com.example.dyb.services.BooksService;
import com.example.dyb.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BooksController {
    //autowire the BooksService class
    @Autowired
    BooksService booksService;

    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/book")
    private List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    //creating a get mapping that retrieves the detail of a specific book
    @GetMapping("/book/{bookid}")
    private Books getBooks(@PathVariable("bookid") int bookid) {
        return booksService.getBooksById(bookid);
    }

    //creating a delete mapping that deletes a specified book
    @DeleteMapping("/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookid) throws UserNotFoundException {
        try {
            booksService.delete(bookid);
        }
        catch (Exception e)
        {
            throw new BookNotFoundException();
        }
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/books")
    private int saveBook(@Valid @RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books.getBookid();
    }

    //creating put mapping that updates the book detail
    @PutMapping("/books")
    private Books update(@RequestBody Books books) {
        booksService.saveOrUpdate(books);
        return books;
    }
}
