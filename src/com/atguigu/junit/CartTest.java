package com.atguigu.junit;

import java.math.BigDecimal;

import org.junit.Test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;

public class CartTest {



	@Test
	public void testAddItem() {
		
		Cart cart = new Cart();
		
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		
		cart.addItem(new CartItem(2, "母猪产后护理II", 1, new BigDecimal(10000), new BigDecimal(10000)));
		
		System.out.println( cart );
	}

	@Test
	public void testDeleteItem() {
		Cart cart = new Cart();
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(2, "母猪产后护理II", 1, new BigDecimal(10000), new BigDecimal(10000)));
		
		cart.deleteItem(1);
		
		System.out.println(cart);
	}

	@Test
	public void testClear() {
		Cart cart = new Cart();
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(2, "母猪产后护理II", 1, new BigDecimal(10000), new BigDecimal(10000)));
		
		cart.clear();
		System.out.println(cart);
		
	}

	@Test
	public void testUpdateItem() {
		Cart cart = new Cart();
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(1, "母猪产后护理I", 1, new BigDecimal(1000), new BigDecimal(1000)));
		cart.addItem(new CartItem(2, "母猪产后护理II", 1, new BigDecimal(10000), new BigDecimal(10000)));
		
		cart.updateItem(2, 2);
		
		System.out.println(cart);
		
	}

}
