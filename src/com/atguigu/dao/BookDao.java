package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Book;

public interface BookDao {
	
	public int saveBook(Book book);
	
	public int deleteBookById(Integer id);
	
	public int updateBook(Book book);
	
	public Book queryBookById(Integer id);
	
	public List<Book> queryBooks();

	public Integer queryForPageTotalCount();

	public List<Book> queryForPageItems(Integer begin,Integer pageSize);

	public Integer queryForPageTotalCountByPrice(Integer min,Integer max);

	public List<Book> queryForPageItemsByPrice(Integer begin,Integer pageSize,Integer min,Integer max);
}
