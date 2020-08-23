package com.atguigu.service.impl;

import java.util.Date;
import java.util.List;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.Page;
import com.atguigu.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();
	@Override
	public String createOrder(Cart cart, Integer userId) {
		//准备一个订单号
		String orderId = System.currentTimeMillis() + "" + userId;
		//创建一个订单
		Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
		//保存订单
		orderDao.saveOrder(order);
		
		//保存订单项
		//遍历每一个购物车中的商品项，然后保存为订单项。
		for (CartItem cartItem : cart.getItems().values()) {
			//将购物车商品项转为订单项
			OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
			
			/**
			 * 提交订单后增加销量并减少库存
			 */
			//查询出你购买的商品
			Book book = bookDao.queryBookById(cartItem.getId());
			//修改销量
			book.setSales(book.getSales() + cartItem.getCount());
			//修改库存
			book.setStock(book.getStock() - cartItem.getCount());
			//保存修改
			bookDao.updateBook(book);
			
			//保存订单项
			orderItemDao.saveOrderItem(orderItem);
		}
		
		//生成订单，清空购物车
		cart.clear();
		
		return orderId;
	}
	@Override
	public List<Order> queryOrders(Integer userId) {
		// TODO Auto-generated method stub
		return orderDao.queryOrders(userId);
	}
	@Override
	public List<OrderItem> queryOrderItems(String orderId) {
		// TODO Auto-generated method stub
		return orderItemDao.queryOrderItems(orderId);
	}
	@Override
	public List<Order> queryAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.queryAllOrders();
	}
	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(order);
	}
	@Override
	public Order queryOrderOne(String orderId) {
		// TODO Auto-generated method stub
		return orderDao.queryOrderOne(orderId);
	}
	
	


}
