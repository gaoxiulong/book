package com.atguigu.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	
	//map集合
	private Map<Integer,CartItem> items = new HashMap<Integer, CartItem>();
	
	/*
	 * 添加商品项
	 */
	public void addItem(CartItem cartItem) {
//		items.add(cartItem);
		//先判断原来购物车中，有没有你要添加的商品
		//根据id获取商品信息
		CartItem item = items.get(cartItem.getId());
		if (item == null) {
			//如果没有，直接添加；
			items.put(cartItem.getId(), cartItem);
		}else {
			//如果有，让原来商品的数量加1
			item.setCount(item.getCount() + 1);
			//单个商品的总金额
			item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
	}
	/*
	 * 删除商品项
	 */
	
	public void deleteItem(Integer id) {
		items.remove(id);
	}
	/*
	 * 清空购物车
	 */
	
	public void clear() {
		items.clear();
	}
	/*
	 * 修改商品信息
	 */
	public void updateItem(Integer id,Integer count) {
		CartItem item = items.get(id);
		if (item != null) {
			//修改商品数量
			item.setCount(count);
			//修改商品总价
			item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
		}
	}
	
	public Integer getTotalCount() {
		Integer totalCount = 0;
		//遍历
		for (CartItem item : items.values()) {
			totalCount += item.getCount();
		}
		return totalCount;
	}
//	public void setTotalCount(Integer totalCount) {
//		this.totalCount = totalCount;
//	}
	public BigDecimal getTotalPrice() {
		BigDecimal totalPrice = new BigDecimal(0);
		for (CartItem item : items.values()) {
			totalPrice = totalPrice.add(item.getTotalPrice());
		}
		return totalPrice;
	}
//	public void setTotalPrice(BigDecimal totalPrice) {
//		this.totalPrice = totalPrice;
//	}

	public Map<Integer, CartItem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, CartItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Cart [totalCount=" + getTotalCount() + ", totalPrice=" + getTotalPrice() + ", items=" + items + "]";
	}
}
