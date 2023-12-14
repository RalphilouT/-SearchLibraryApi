package com.example.library.repository;

import com.example.library.Entity.BookEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends MongoRepository<BookEntity, String>{
    @Override
    @NotNull
    Optional<BookEntity> findById(String s);

    @Query("Select * FROM springdata")
    Optional<BookEntity> findByTitle(String s);

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
    List<BookEntity> findByName(String s);

    @Query("{ 'ISBN' : ?0 }")
    Optional<BookEntity> findByISBN(String isbn);
}
