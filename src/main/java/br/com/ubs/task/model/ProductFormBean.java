package br.com.ubs.task.model;

import java.util.ArrayList;
import java.util.List;

public class ProductFormBean {
	private String item;
	private List<Product> products;
	private Integer totalPrice;	
	private List<String> productsDiscount = new ArrayList<String>();
	private boolean finalize;
	private boolean add;
	private String message;

	public ProductFormBean() {
		
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<String> getProductsDiscount() {
		return productsDiscount;
	}

	public void setProductsDiscount(List<String> productsDiscount) {
		this.productsDiscount = productsDiscount;
	}

	public boolean isFinalize() {
		return finalize;
	}

	public void setFinalize(boolean finalize) {
		this.finalize = finalize;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}
