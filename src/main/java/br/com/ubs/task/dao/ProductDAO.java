package br.com.ubs.task.dao;

import br.com.ubs.task.model.Product;
import br.com.ubs.task.util.Constants;

public class ProductDAO {

	public Product getById(String id) {
		Product product = null;

		if (id.equalsIgnoreCase(Constants.PRODUCT_A)) {
			product = new Product();
			product.setItem(Constants.PRODUCT_A);
			product.setDescription(Constants.PRODUCT_A_NAME);
			product.setUnitPrice(Constants.PRODUCT_A_PRICE);
			product.setDiscount(Constants.PRODUCT_A_DISCOUNT);
			product.setQuantityDiscount(Constants.PRODUCT_A_NUM_ITEM_DISCOUNT);
		} else if (id.equalsIgnoreCase(Constants.PRODUCT_B)) {
			product = new Product();
			product.setItem(Constants.PRODUCT_B);
			product.setDescription(Constants.PRODUCT_B_NAME);
			product.setUnitPrice(Constants.PRODUCT_B_PRICE);
			product.setDiscount(Constants.PRODUCT_B_DISCOUNT);
			product.setQuantityDiscount(Constants.PRODUCT_B_NUM_ITEM_DISCOUNT);
		} else if (id.equalsIgnoreCase(Constants.PRODUCT_C)) {
			product = new Product();
			product.setItem(Constants.PRODUCT_C);
			product.setDescription(Constants.PRODUCT_C_NAME);
			product.setUnitPrice(Constants.PRODUCT_C_PRICE);
			product.setDiscount(Constants.PRODUCT_C_DISCOUNT);
			product.setQuantityDiscount(Constants.PRODUCT_C_NUM_ITEM_DISCOUNT);
		} else if (id.equalsIgnoreCase(Constants.PRODUCT_D)) {
			product = new Product();
			product.setItem(Constants.PRODUCT_D);
			product.setDescription(Constants.PRODUCT_D_NAME);
			product.setUnitPrice(Constants.PRODUCT_D_PRICE);
			product.setDiscount(Constants.PRODUCT_D_DISCOUNT);
			product.setQuantityDiscount(Constants.PRODUCT_D_NUM_ITEM_DISCOUNT);
		}

		return product;
	}
}
