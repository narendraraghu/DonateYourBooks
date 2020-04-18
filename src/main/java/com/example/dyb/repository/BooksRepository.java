package com.example.dyb.repository;

import com.example.dyb.model.Books;
import org.springframework.data.repository.CrudRepository;

public interface BooksRepository extends CrudRepository<Books, Integer>
{
}