package com.atguigu.junit;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

public class BookServiceTest {
	
	static BookService bookService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		bookService = new BookServiceImpl();
	}

	@Test
	public void testAddBook() {
		bookService.addBook(new Book(null, "java编程", "张三丰", new BigDecimal(99), 1000, 9999, null));
	}

	@Test
	public void testDeleteBookById() {
		
		bookService.deleteBookById(9);
	}

	@Test
	public void testUpdateBook() {

		bookService.updateBook(new Book(9, "java编程", "高尚", new BigDecimal(99), 999, 10, null));
	}

	@Test
	public void testQueryBookById() {
		System.out.println(bookService.queryBookById(9));
	}

	@Test
	public void testQueryBooks() {
		bookService.queryBooks().forEach(System.out::println);
	}
	
	@Test
	public void testpage() {
		System.out.println(bookService.page(2, Page.PAGE_SIZE));
	}
	
	@Test
	public void testpageByPrice() {
		System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50));
	}

}
