package com.atguigu.dao;

import java.util.List;

import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public interface OrderItemDao {
	
	public int saveOrderItem(OrderItem orderItem);
	
	public List<OrderItem> queryOrderItems(String orderId);

}
