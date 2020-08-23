package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookdao = new BookDaoImpl();
	
	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
		bookdao.saveBook(book);

	}

	@Override
	public void deleteBookById(Integer id) {
		// TODO Auto-generated method stub
		
		bookdao.deleteBookById(id);

	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
		bookdao.updateBook(book);

	}

	@Override
	public Book queryBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookdao.queryBookById(id);
	}

	@Override
	public List<Book> queryBooks() {
		// TODO Auto-generated method stub
		return bookdao.queryBooks();
	}

	@Override
	public Page<Book> page(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		Page<Book> page = new Page<Book>();
		//设置每页显示数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookdao.queryForPageTotalCount();
		page.setPageTotalCount(pageTotalCount);
		//求总页数
		Integer pageTotal = pageTotalCount / page.getPageSize();
		if (pageTotalCount % page.getPageSize() > 0 ) {
			pageTotal++;
		}
		page.setPageTotal(pageTotal);
		
		//设置当前页码，先设置pageTotal，后设置pageNo。
		page.setPageNo(pageNo);
		
		//求begin
		Integer begin = (page.getPageNo()-1)*page.getPageSize();
		//获取当前页数据
		List<Book> items = bookdao.queryForPageItems(begin,page.getPageSize());
		//设置当前页数据
		page.setItems(items);
		return page;
	}

	@Override
	public Page<Book> pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
		// TODO Auto-generated method stub
		Page<Book> page = new Page<Book>();
		//设置每页显示数量
		page.setPageSize(pageSize);
		//求总记录数
		Integer pageTotalCount = bookdao.queryForPageTotalCountByPrice(min, max);
		page.setPageTotalCount(pageTotalCount);
		//求总页数
		Integer pageTotal = pageTotalCount / page.getPageSize();
		if (pageTotalCount % page.getPageSize() > 0 ) {
			pageTotal++;
		}
		page.setPageTotal(pageTotal);
		
		//设置当前页码，先设置pageTotal，后设置pageNo。
		page.setPageNo(pageNo);
		
		//求begin
		Integer begin = (page.getPageNo()-1)*page.getPageSize();
		//获取当前页数据
		List<Book> items = bookdao.queryForPageItemsByPrice(begin, page.getPageSize(), min, max);
		//设置当前页数据
		page.setItems(items);
		return page;
	}

}
