package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 分页功能
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1 获取请求的参数
		Integer pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
		Integer pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		//2 调用bookService.page(pageNo,pageSize):Page对象
		Page<Book> page = bookService.page(pageNo, pageSize);
		
		//设置分页url
		page.setUrl("manager/bookServlet?action=page");
		
		//3 保存分页数据到request域中
		request.setAttribute("page", page);
		//4 转发到图书列表管理页面/pages/manager/book_manager.jsp页面
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取请求的参数（如有）
		//2 调用BookService.queryBooks()查询全部的图书信息
		List<Book> list = bookService.queryBooks();
		//3 保存图书到request域中
		request.setAttribute("books", list);
		//4 转发到/pages/manager/book_manager.jsp
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1 获取请求参数封装成Book对象
		Book book = Utils.copyParamToBean(request.getParameterMap(), new Book());
		//2 调用bookService.addBook()方法添加图书
	    bookService.addBook(book);
	    //3 重定向到图书列表页面，不能使用请求转发操作，如果使用了就会操作重复添加记录的问题。
	    //System.out.println(request.getContextPath());
	    response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + Integer.MAX_VALUE);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取请求的参数，图书编号
		Integer id = Utils.parseInt(request.getParameter("id"), 0);
		System.out.println(id);
		//2 调用bookService.deleteBook()方法删除图书
		bookService.deleteBookById(id);
		//3 重定向到图书列表页面
		 response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取请求的参数，图书编号
		Integer id = Utils.parseInt(request.getParameter("id"), 0);
		//2 调用bookService.queryBookById()保存到request域中
		request.setAttribute("book", bookService.queryBookById(id));
		//3 请求转发到图书列表页面
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);;
		
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取请求的参数封装成book对象
		Book book = Utils.copyParamToBean(request.getParameterMap(), new Book());
		//2 调用bookService.updateBook()方法更新图书
		bookService.updateBook(book);
		//3 重定向到图书列表页面
		response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo=" + request.getParameter("pageNo"));
	}
	
}
