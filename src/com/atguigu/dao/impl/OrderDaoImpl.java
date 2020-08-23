package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		// TODO Auto-generated method stub
		String sql =  "insert into t_order(`order_id` , `create_time` , `price` , `status` , `user_id`) values(? , ? , ? , ? , ?)";
		
		return update(sql, order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
	}

	@Override
	public List<Order> queryOrders(Integer userid) {
		String sql = "select `order_id` as orderId , `create_time` as createTime, `price` , `status` , `user_id` as userId from t_order  where user_id = ?";
		
		return queryList(sql, Order.class, userid);
	}

	@Override
	public List<Order> queryAllOrders() {
		
		String sql = "select `order_id` as orderId , `create_time` as createTime, `price` , `status` , `user_id` as userId from t_order";
		
		return queryList(sql, Order.class);
	}

	@Override
	public int updateOrder(Order order) {
		String sql = "update t_order set create_time=?,price=?,status=?, user_id =? where order_id = ?";
		return update(sql, order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId(),order.getOrderId());
	}

	@Override
	public Order queryOrderOne(String orderId) {
		// TODO Auto-generated method stub
		
		String sql = "select `order_id` as orderId , `create_time` as createTime, `price` , `status` , `user_id` as userId from t_order  where order_id = ?";
		return queryOne(sql, Order.class, orderId);
	}

}
