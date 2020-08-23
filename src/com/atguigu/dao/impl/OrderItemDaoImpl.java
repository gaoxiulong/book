package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDaoImpl implements OrderItemDao{

	@Override
	public int saveOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		String sql =  "insert into t_order_item(`id` , `name` , `count` , `price` , `total_price`,`order_id`) values(null, ? , ? , ? , ? , ?)";
		return update(sql, orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
	}

	
	
	@Override
	public List<OrderItem> queryOrderItems(String orderId) {
		// TODO Auto-generated method stub
		String sql =  "select `id` , `name` , `count` , `price` , `total_price` as totalPrice ,`order_id` as orderId from t_order_item where order_id = ? ";
		
		return queryList(sql, OrderItem.class, orderId);
	}

}
