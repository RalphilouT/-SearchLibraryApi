package com.example.library.controller;

import com.example.library.Entity.BookEntity;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @CrossOrigin
    @GetMapping("/book/{bookName}")
    public List<BookEntity> getBook(@PathVariable("bookName") String bookName){
        return bookService.getBookName(bookName);
    }
}
