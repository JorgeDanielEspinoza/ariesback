package com.apirest.ariesbackend.BookList.BooksRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.ariesbackend.BookList.Books.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}

