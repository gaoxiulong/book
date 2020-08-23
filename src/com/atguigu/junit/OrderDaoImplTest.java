package com.atguigu.junit;


import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;

public class OrderDaoImplTest {

	@Test
	public void test() {
		OrderDao orderdao = new OrderDaoImpl();
		orderdao.saveOrder(new Order("0101010102", new Date(), new BigDecimal(2000), 0, 1));
	}
	
	@Test
	public void test1() {
		OrderDao orderdao = new OrderDaoImpl();
	    orderdao.queryOrders(1).forEach(System.out::println);
	    
	}
	
	@Test
	public void test2() {
		OrderDao orderdao = new OrderDaoImpl();
	    orderdao.queryAllOrders().forEach(System.out::println);
	    
	}
	
	@Test
	public void test3() {
		OrderDao orderdao = new OrderDaoImpl();
	    orderdao.updateOrder(new Order("15953116248181", new Date(),new BigDecimal(228), 0, 1));
	    
	}
	
	@Test
	public void test4() {
		OrderDao orderdao = new OrderDaoImpl();
	  //  System.out.println();
	   System.out.println(orderdao.queryOrderOne("15953116248181"));
	    
	}

}
