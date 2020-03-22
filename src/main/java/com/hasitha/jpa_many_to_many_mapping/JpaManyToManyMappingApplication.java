package com.hasitha.jpa_many_to_many_mapping;

import com.hasitha.jpa_many_to_many_mapping.entity.Author;
import com.hasitha.jpa_many_to_many_mapping.entity.Book;
import com.hasitha.jpa_many_to_many_mapping.repository.AuthorRepository;
import com.hasitha.jpa_many_to_many_mapping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaManyToManyMappingApplication{

	@Autowired
	BookRepository bookRepository;

	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaManyToManyMappingApplication.class, args);
	}



}
