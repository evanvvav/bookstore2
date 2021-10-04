package com.example.bookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepository;
import com.example.bookStore.domain.Category;
import com.example.bookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository) {
		return (args) -> {

			categoryRepository.save(new Category("Mistery"));
			categoryRepository.save(new Category("Poetry"));
			categoryRepository.save(new Category("Horror"));

			repository.save(
					new Book("Book 1", "Author 1", 2000, "123456", categoryRepository.findByName("Mistery").get(0)));
			repository.save(
					new Book("Book 2", "Author 2", 2002, "123458", categoryRepository.findByName("Horror").get(0)));
		};
	}

}