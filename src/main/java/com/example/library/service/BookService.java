package com.example.library.service;

import com.example.library.Entity.BookEntity;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getBookName(String bookName){
        return bookRepository.findByName(bookName);
    }

}
