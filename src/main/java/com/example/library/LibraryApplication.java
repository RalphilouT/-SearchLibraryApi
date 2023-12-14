package com.example.library;

import com.example.library.Entity.BookEntity;
import com.example.library.repository.BookRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}
	@Component
	public class CorsFilter extends OncePerRequestFilter {

		@Override
		protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
										final FilterChain filterChain) throws ServletException, IOException {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers");
			response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addIntHeader("Access-Control-Max-Age", 10);
			filterChain.doFilter(request, response);
		}
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
