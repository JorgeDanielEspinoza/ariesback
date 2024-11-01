package com.apirest.ariesbackend.BookList.BooksController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.ariesbackend.BookList.Books.Book;
import com.apirest.ariesbackend.BookList.BooksService.BookService;

@RestController
@RequestMapping("/api/booklist")
@CrossOrigin
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // http://localhost:8080/api/booklist
    @PostMapping
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    // http://localhost:8080/api/booklist
    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // http://localhost:8080/api/booklist/1
    @GetMapping("/{id}")
    public Book findById(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    // http://localhost:8080/api/booklist/1
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        bookService.deleteById(id);
    }

    // http://localhost:8080/api/booklist
    @PutMapping
    public Book updateBook(@RequestBody Book book, @RequestParam Integer quantity) {
        Book bookDb = bookService.findById(book.getId());
        bookDb.setPrice(book.getPrice());
        int newStock = bookDb.getStock() - quantity;
        if (newStock < 0) {
            throw new RuntimeException("Stock cannot be negative");
        }
        bookDb.setStock(newStock);
        return bookService.update(bookDb);
    }

    // http://localhost:8080/api/booklist/update
    @PutMapping ("/update")
    public Book updatePriceStock(@RequestBody Book book){
        Book bookDb = bookService.findById(book.getId());
        bookDb.setPrice(book.getPrice());
        bookDb.setStock(book.getStock());
        return bookService.update(bookDb);
    }

}