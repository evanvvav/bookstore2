package com.example.bookStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.bookStore.web.BookStoreController;
import com.example.bookStore.web.CategoryController;

@ExtendWith(SpringExtension.class)
@SpringBootTest

public class SmokeTestControllers {

	@Autowired
	private BookStoreController bookStoreController;

	@Autowired
	private CategoryController categoryController;

	@Test
	public void contextLoadsBookStoreController() throws Exception {
		assertThat(bookStoreController).isNotNull();
	}

	@Test
	public void contextLoadsCategoryController() throws Exception {
		assertThat(categoryController).isNotNull();
	}

}
