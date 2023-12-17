package com.example.library.controller;

import com.example.library.Entity.BookEntity;
import com.example.library.service.BookService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(maxAge = 3600, allowCredentials = "true", origins = "http://localhost:3000")
@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/book/{bookName}")
    public List<BookEntity> getBook(@PathVariable("bookName") String bookName){
        return bookService.getBookName(bookName);
    }
}
