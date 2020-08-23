package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class ClientBookServlet
 */
public class ClientBookServlet extends BaseServlet {
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
		page.setUrl("client/bookServlet?action=page");
		
		//3 保存分页数据到request域中
		request.setAttribute("page", page);
		//4 转发到前台index.jsp
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}
	
	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 获取请求的参数
		Integer pageNo = Utils.parseInt(request.getParameter("pageNo"), 1);
		Integer pageSize = Utils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
		Integer min = Utils.parseInt(request.getParameter("min"), 0);
		Integer max = Utils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
		//2 调用bookService.page(pageNo,pageSize):Page对象
		Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
		
		//设置分页url
		StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
		
		if (request.getParameter("min") != null) {
			sb.append("&min=").append(min);
		}
		if (request.getParameter("max") != null) {
			sb.append("&max=").append(max);
		}
		//设置url
		page.setUrl(sb.toString());
		
		//3 保存分页数据到request域中
		request.setAttribute("page", page);
		//4 转发到前台index.jsp
		request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
	}
}
