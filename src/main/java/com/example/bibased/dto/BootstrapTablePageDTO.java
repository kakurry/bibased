package com.example.bibased.dto;

import com.example.bibased.util.JqPage;

import java.util.List;



public class BootstrapTablePageDTO {
	private List<?> rows;
	private String page;// 当前页
	private String total;// 总页数
	private String records;// 总记录数
	private String pageSize;
	protected boolean hasPreviousPage = true;
	protected boolean hasNextPage = true;
	protected boolean lastPage = false;
	protected boolean firstPage = false;

	public BootstrapTablePageDTO(String totalPage) {
		super();
		this.records = totalPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public boolean isLastPage() {
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isFirstPage() {
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	// 赋值
	public BootstrapTablePageDTO pageValue(JqPage page, List<?> list) {
		this.setPage(page.getPageNo() + "");
		this.setRows(list);
		int pages = 0;
		int t = Integer.parseInt(this.records);
		pages = t / page.getPageSize();
		if (t % page.getPageSize() > 0) {
			pages++;
		}
		this.setTotal(records);
		// this.setTotal(String.valueOf(pages));
		return this;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getRecords() {
		return records;
	}

	public void setRecords(String records) {
		this.records = records;
	}

}
