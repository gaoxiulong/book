package com.atguigu.junit;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

public class OrderServiceTest {

	@Test
	public void test() {
		OrderService orderService = new OrderServiceImpl();
		
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		
		cart.addItem(new CartItem(2, "母猪产后护理II", 1, new BigDecimal(10000), new BigDecimal(10000)));
		
		orderService.createOrder(cart, 1);
	}
	
	@Test
	public void test1() {
		OrderService orderService = new OrderServiceImpl();
		System.out.println(orderService.queryOrders(1));
		
	}
	
	@Test
	public void test2() {
		OrderService orderService = new OrderServiceImpl();
		orderService.queryOrderItems("15952387089291").forEach(System.out::println);
		
	}
	
	@Test
	public void test3() {
		OrderService orderService = new OrderServiceImpl();
		orderService.queryAllOrders().forEach(System.out::println);
		
	}
	
	@Test
	public void test4() {
		OrderService orderService = new OrderServiceImpl();
		orderService.updateOrder(new Order("15953116248181", new Date(),new BigDecimal(228), 0, 1));
		
	}

	@Test
	public void test5() {
		OrderService orderService = new OrderServiceImpl();
		System.out.println(orderService.queryOrderOne("15953116248181"));
	}
}
