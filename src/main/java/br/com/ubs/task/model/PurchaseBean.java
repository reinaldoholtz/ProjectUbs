package br.com.ubs.task.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseBean {
	private static List<Product> products = new ArrayList<Product>();
	private static Integer totalPrice = 0;
	private static Map<Product,Integer> productDiscount = new HashMap<Product,Integer>();
	
	public static Integer getTotalPrice() {
		return totalPrice;
	}
		
	public static void addProduct(Product product) {
		int count = 0;
		products.add(product);
		if (product.getDiscount() != 0){
		   if (productDiscount.containsKey(product)){
			   count = productDiscount.get(product); 
		   }
		   productDiscount.put(product, ++count);
		}   
		totalPrice = totalPrice + product.getUnitPrice();
	}
	
	public static void setTotalPrice(Integer totalPrice) {
		PurchaseBean.totalPrice = totalPrice;
	}

	private PurchaseBean() {
	}

	public static List<Product> getProducts() {
		return products;
	}

	public static void setProducts(List<Product> products) {
		PurchaseBean.products = products;
	}

	public static Map<Product, Integer> getProductDiscount() {
		return productDiscount;
	}

	public static void setProductDiscount(Map<Product, Integer> productDiscount) {
		PurchaseBean.productDiscount = productDiscount;
	}
	
}

