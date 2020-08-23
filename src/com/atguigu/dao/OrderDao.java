package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Order;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

public interface OrderDao {
	
	public int saveOrder(Order order);

	//public Order queryOrderByUserId(Integer useId);
	
	public List<Order> queryOrders(Integer userid);
	
	public List<Order> queryAllOrders();
	
	public int updateOrder(Order order);
	
	public Order queryOrderOne(String orderId);
}
