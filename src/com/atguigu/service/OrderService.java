package com.atguigu.service;

import java.util.List;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.pojo.Page;

public interface OrderService {

	public String createOrder(Cart cart,Integer userId);
	
	public List<Order> queryOrders(Integer userId);
	
	public List<OrderItem> queryOrderItems(String orderId);
	
	public List<Order> queryAllOrders();
	
	public int updateOrder(Order order);
	
	public Order queryOrderOne(String orderId);

//	public Page<Order> page(Integer pageNo, Integer pageSize);
}
