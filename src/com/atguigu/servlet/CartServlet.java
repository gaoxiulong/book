package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookServiceImpl();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取请求参数，传商品编号
		Integer id = Utils.parseInt(request.getParameter("id"), 0);
		//2 调用bookService.queryBookById(id):book图书
		Book book = bookService.queryBookById(id);
		//3 将book数据转为CartItem购物车对象
		CartItem cartItem = new CartItem(book.getId(), book.getName(),1, book.getPrice(), book.getPrice());
		//4 准备cart购物车对象
		//Cart cart  = new Cart();  存在bug，修正后的代码如下：
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (cart == null) {
			//之前没有购物车
			cart = new Cart();
			//把购物车放到session域中
			request.getSession().setAttribute("cart", cart);
		}
		
		//首页显示最后一个添加到购物车的商品：把最后一个添加的商品名称，保存到Session域中
		request.getSession().setAttribute("last_name", cartItem.getName());
		
		
		//5 调用cart.addItem（cartItem）
		cart.addItem(cartItem);
		System.out.println(cart);
		//6 跳回商品列表页面-->跳转到请求的页面
		//response.sendRedirect(request.getContextPath());
		response.sendRedirect(request.getHeader("Referer"));
		
		
	}
	
	protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取要删除的商品id
		Integer id = Utils.parseInt(request.getParameter("id"), 0);
		//2 获取cart购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//3 调用cart.deleteItem方法删除商品项
		cart.deleteItem(id);
		//4 跳回到请求的页面
		response.sendRedirect(request.getHeader("Referer"));
		
	}
	
	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取cart购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//2 调用cart.clear方法清空购物车
		cart.clear();
		//3 跳回到请求的页面
		response.sendRedirect(request.getHeader("Referer"));
	}
	
	protected void updateItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1 获取请求的参数：商品id、商品数量
		Integer count = Utils.parseInt(request.getParameter("count"), 1);
		Integer id = Utils.parseInt(request.getParameter("id"), 0);
		//2 获取购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		//3 调用updateItem方法修改商品数量
		cart.updateItem(id, count);
		//4 重定向回请求发起的页面
		response.sendRedirect(request.getHeader("Referer"));
	}

}
