package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.Page;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.util.Utils;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private OrderService orderService = new OrderServiceImpl();
	
	/*
	 * 更新订单状态
	 */
	
	protected void updateOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取请求参数：orderId、status
		String orderId = request.getParameter("orderId"); 
		String status = request.getParameter("status");
		//根据orderId获取订单数据
		Order order = orderService.queryOrderOne(orderId);
		order.setStatus(Integer.parseInt(status));
		
		System.out.println(order);
		//1 获取请求参数包装成order对象
//    	Order order = Utils.copyParamToBean(request.getParameterMap(), new Order());
		
		//2 调用方法updateOrder进行订单状态更新
		orderService.updateOrder(order);
		
		//3 请求转发到订单页面
		response.sendRedirect(request.getHeader("Referer"));
	}
	
	/*
	 * 查看全部订单
	 */
	
	protected void queryAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取请求参数：无
		
		//2 调用方法orderDao.queryOrders(userId)获取数据
		List<Order> orders = orderService.queryAllOrders();
		
		//3 保存数据到域中
		request.setAttribute("allorder", orders);
		
		//4 请求转发到order.jsp页面
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
		
	}
	
	
	/**
	 * 查看订单
	 */
	protected void queryOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 获取请求参数：userId
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			//用户没有登录，跳转到登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			return;
		}
		Integer userId = user.getId();
		
		//2 调用方法orderDao.queryOrders(userId)获取数据
		List<Order> orders = orderService.queryOrders(userId);
		
		//3 保存数据到域中
		request.setAttribute("order", orders);
		
		//4 请求转发到order.jsp页面
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
		
	}
	/*
	 * 查看订单详情
	 */
	protected void queryItemOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 获取请求参数：orderId
		String orderId = request.getParameter("orderId");
		//2 调用orderService.queryOrderItems方法获取详情数据
		List<OrderItem> orderItems = orderService.queryOrderItems(orderId);
		//3 保存数据到request域中
		request.setAttribute("orderItems", orderItems);
		
		//4 请求转发到页面
		String flag = request.getParameter("flag");
		if ("1".equals(flag)) {
			//后台管理过来的，则跳转到后台管理订单页面
			request.getRequestDispatcher("/pages/manager/order_manager2.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/pages/order/order2.jsp").forward(request, response);
	}

	/*
	 * 创建订单
	 */
	
	protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 获取请求的参数：cart、user信息保存在session中
		//1.1获取购物车对象
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		//1.2获取用户id
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			//用户没有登录，跳转到登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			return;
		}
		Integer userId = user.getId();
		
		//2 调用orderService.createOrder(cart,userId)
		/**
		 * 使用threadLocal统一进行数据库事务的管理功能：
		 * 需要对XxxService.xxx()进行try-catch，使用TransactionFilter进行统一try-catch解决
		 */
		String orderId = orderService.createOrder(cart, userId);
		
		//3订单号保存到请求域中
		request.setAttribute("orderId", orderId);
		
		//4 转发
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
		
		
	}
}
