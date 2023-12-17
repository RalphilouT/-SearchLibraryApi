package com.example.library.controller;

import com.example.library.Entity.BookEntity;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@CrossOrigin(maxAge = 3600, allowCredentials = "true", origins = "http://localhost:3000")
@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
//    @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = {"Requestor-Type", "Authorization","Access-Control-Allow-Origin"}, exposedHeaders = "X-Get-Header")    @GetMapping("/book/{bookName}")
    @GetMapping("/book/{bookName}")
    public List<BookEntity> getBook(@PathVariable("bookName") String bookName){
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-Get-Header", "Access-Control-Allow-Origin");
        return bookService.getBookName(bookName);
    }
}
