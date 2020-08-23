package com.atguigu.pojo;

import java.util.List;

public class Page <T>{
	
	public static final Integer PAGE_SIZE = 4;
	
	//当前页码
	private Integer pageNo;
	//总页码
	private Integer pageTotal;
	//总记录数
	private Integer pageTotalCount;
	//每页显示几条记录
	private Integer pageSize = PAGE_SIZE;
	//当前页数据，list有序集合
	private  List<T> items;
	/**
	 * 分页中url访问地址
	 */
	private String url;
	
	public Integer getPageNo() {
		return pageNo;
	}
	
	public void setPageNo(Integer pageNo) {
		//数据边界性有效性检查
		if (pageNo < 1) {
			pageNo = 1;
		}
		if (pageNo > pageTotal) {
			pageNo = pageTotal;
		}
		this.pageNo = pageNo;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageTotalCount=" + pageTotalCount
				+ ", pageSize=" + pageSize + ", items=" + items + "]";
	}
}
