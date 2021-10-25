package com.example.bookStore;

import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepository;
import com.example.bookStore.domain.Category;
import com.example.bookStore.domain.CategoryRepository;
import com.example.bookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {
	// private static final Logger log =
	// LoggerFactory.getLogger(BookStoreApplication.class);

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

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

			UserRepository.save(user1);
			UserRepository.save(user2);

			/*
			 * log.info("fetch all books"); for (Book book : BookRepository.findAll()) {
			 * log.info(book.toString()); }
			 */
		};

	}

}