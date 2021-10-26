package com.example.bookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookStore.domain.Book;
import com.example.bookStore.domain.BookRepository;
import com.example.bookStore.domain.Category;
import com.example.bookStore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Book 1");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Author 1");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Book 3", "Author 3", 2021, "123456", null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = categoryRepository.findByName("Mistery");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryId()).isEqualTo(1);

	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Comedy");
		categoryRepository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}

}
