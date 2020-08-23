package com.atguigu.junit;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;

public class OrderItemDaoImplTest {

	@Test
	public void test() {
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		orderItemDao.saveOrderItem(new OrderItem(null, "酷哥", 1, new BigDecimal(99), new BigDecimal(99), "0101010102"));
//		orderItemDao.saveOrderItem(new OrderItem(null, "酷哥", 1, new BigDecimal(99), new BigDecimal(99), "0101010101"));
		
	}
	
	@Test
	
	public void test1() {
		OrderItemDao orderItemDao = new OrderItemDaoImpl();
		orderItemDao.queryOrderItems("15952387089291").forEach(System.out::println);;
		
	}

}
