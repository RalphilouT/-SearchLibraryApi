package com.example.library.Entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document
public class BookEntity {
    @Id
    private int id;
    private String title;

    @Indexed(unique = true)
    private String ISBN;

    private String description;
    private List<String> bookSuggestion;

    public BookEntity(int id, String title, String ISBN, String description, List<String> bookSuggestion) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.description = description;
        this.bookSuggestion = bookSuggestion;
    }
}
