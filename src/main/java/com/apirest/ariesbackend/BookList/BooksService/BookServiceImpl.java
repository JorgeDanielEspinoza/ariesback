package com.apirest.ariesbackend.BookList.BooksService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apirest.ariesbackend.BookList.Books.Book;
import com.apirest.ariesbackend.BookList.BooksRepository.BookRepository;

@Service
public class BookServiceImpl implements  BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () ->{
                    throw new RuntimeException("no se encontro el id");
                }
        );
        return book;
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }
}