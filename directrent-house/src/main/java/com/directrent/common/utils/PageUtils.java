package com.directrent.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 */
public class PageUtils<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int total;
	private List<T> rows;

	public PageUtils() {
	}

	public PageUtils(List<T> list, int total) {
		this.rows = list;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
