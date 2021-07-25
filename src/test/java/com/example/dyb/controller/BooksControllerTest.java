package com.example.dyb.controller;

import com.example.dyb.model.Books;
import com.example.dyb.services.BooksService;
import com.example.dyb.services.ValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BooksService booksService;

    @MockBean
    ValidationService validationService;




    @Test
    public void getAllBooksTest() throws Exception {
        when(booksService.getAllBooks()).thenReturn(
                Arrays.asList(new Books(2,"ABC","Narendra",10))
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/book")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{bookId:2,bookName:ABC,author:Narendra,price:10}]"))
                .andReturn();

    }

    @Test
    public void getAllBooksTest_withMultipleEntries() throws Exception {
        when(booksService.getAllBooks()).thenReturn(
                Arrays.asList(new Books(1,"ABC","Narendra",10),
                        new Books(2,"ABCD","Narendra",10),
        new Books(3,"ABCDE","Narendra",10))
        );
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/book")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{bookId:1,bookName:ABC,author:Narendra,price:10},{bookId:2,bookName:ABCD,author:Narendra,price:10},{bookId:3,bookName:ABCDE,author:Narendra,price:10}]"))
                .andReturn();

    }


}