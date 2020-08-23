package com.atguigu.junit;

import java.math.BigDecimal;
import org.junit.BeforeClass;
import org.junit.Test;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

public class BookDaoTest {

	static BookDao bookdao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		// TODO Auto-generated method stub
		bookdao = new BookDaoImpl();
	}
	
	@Test
	public void testSaveBook() {
		
		 bookdao.saveBook(new Book(null,"葵花宝典","张国荣",new BigDecimal(99), 1000, 99999, null));
	}

	@Test
	public void testDeleteBook() {
		
		bookdao.deleteBookById(7);
	}

	@Test
	public void testUpdateBook() {
		bookdao.updateBook(new Book(6,"葵花宝典2","张国荣2",new BigDecimal(99), 1000, 99999, null));
	}

	@Test
	public void testQueryBookById() {
		System.out.println( bookdao.queryBookById(6) );
	}

	@Test
	public void testQueryBooks() {
		bookdao.queryBooks().forEach(System.out::println);
	}
	
	@Test
	public void testqueryForPageTotalCount() {
		System.out.println(bookdao.queryForPageTotalCount());
	}
	
	@Test
	public void testqueryForPageItems() {
		bookdao.queryForPageItems(4, Page.PAGE_SIZE).forEach(System.out::println);
	}

	@Test
	public void testqueryForPageTotalCountByPrice() {
		System.out.println(bookdao.queryForPageTotalCountByPrice(10, 50));
	}
	
	@Test
	public void testqueryForPageItemsByPrice() {
		bookdao.queryForPageItemsByPrice(4, Page.PAGE_SIZE, 10, 50).forEach(System.out::println);
	}
}
