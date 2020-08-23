package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;

public class BookDaoImpl extends BaseDaoImpl implements BookDao {

	@Override
	public int saveBook(Book book) {
		String sql = "insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`) values(? , ? , ? , ? , ? , ?)";
		
		return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath());
	}

	@Override
	public int deleteBookById(Integer id) {
		String sql = "delete from t_book where id = ?";
		
		return update(sql, id);
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id = ?";
		return update(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgpath(),book.getId());
	}

	@Override
	public Book queryBookById(Integer id) {
		String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where id = ? ";
		return queryOne(sql, Book.class, id);
	}

	@Override
	public List<Book> queryBooks() {
		String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book";
		return queryList(sql, Book.class);
	}

	@Override
	public Integer queryForPageTotalCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_book";
		Object count = queryForSingleValue(sql);
		return new Integer(count.toString());
	}

	@Override
	public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
		// TODO Auto-generated method stub
		String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ? , ?";
		return queryList(sql, Book.class, begin,pageSize);
	}

	@Override
	public Integer queryForPageTotalCountByPrice(Integer min, Integer max) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_book where price between ? and ?";
		Object count = queryForSingleValue(sql,min,max);
		return new Integer(count.toString());
	}

	@Override
	public List<Book> queryForPageItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max) {
		// TODO Auto-generated method stub
		String sql = "select `id` ,`name` , `author` , `price` , `sales` , `stock` , `img_path`"
				+ " from t_book where price between ? and ?  order by price limit ? , ?";
		return queryList(sql, Book.class,min,max, begin,pageSize);
	}

}
