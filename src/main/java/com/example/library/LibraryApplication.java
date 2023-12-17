package com.example.library;

import com.example.library.Entity.BookEntity;
import com.example.library.repository.BookRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}




	@Bean
	CommandLineRunner runner(BookRepository repository, MongoTemplate mongoTemplate){
		return args -> {

			ArrayList<String> bookSuggestion = new ArrayList<String>();
			bookSuggestion.add("Narnia");
			bookSuggestion.add("Lord of the Ring");
			BookEntity bookEntity = new BookEntity(
					1,
					"Ex"
					,"2022"
					,"description"
					, bookSuggestion
			);
			BookEntity bookEntity1 = new BookEntity(
					2,
					"Harry Potter"
					,"2023"
					,"descriptions"
					,bookSuggestion
			);
			BookEntity bookEntity2 = new BookEntity(
					3,
					"Potter"
					,"2024"
					,"descriptions"
					,bookSuggestion
			);



			repository.findByISBN("2022").ifPresentOrElse(
					s->{
						System.out.println( s + " already exists");
					}, () -> {
						System.out.println("Inserting Book " + bookEntity);
						repository.insert(bookEntity);
					}
			);
			repository.findByISBN("2023").ifPresentOrElse(
					s->{
						System.out.println( s + " already exists");
					}, () -> {
						System.out.println("Inserting Book " + bookEntity1);
						repository.insert(bookEntity1);
					}
			);
			repository.findByISBN("2024").ifPresentOrElse(
					s->{
						System.out.println( s + " already exists");
					}, () -> {
						System.out.println("Inserting Book " + bookEntity2);
						repository.insert(bookEntity2);
					}
			);
			repository.findByISBN("2022").ifPresentOrElse( s->{
				System.out.println(s.getTitle());
			}, () ->{
				System.out.println("Does not exist");
			});

		};
	}



}
