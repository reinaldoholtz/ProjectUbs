package br.com.ubs.task.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.ubs.task.dao.ProductDAO;
import br.com.ubs.task.model.Product;
import br.com.ubs.task.model.ProductFormBean;
import br.com.ubs.task.model.PurchaseBean;
import br.com.ubs.task.util.Constants;

/** Class of control that calls the view corresponds to the event
 * @author Reinaldo Holtz
 * @version 1.00
 */
@Controller
@RequestMapping(value = {"/product"})
public class ProductController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("productForm") ProductFormBean productForm) {
		PurchaseBean.setProducts(new ArrayList<Product>());
		PurchaseBean.setProductDiscount(new HashMap<Product,Integer>());
		PurchaseBean.setTotalPrice(0);
		productForm.setFinalize(false);
		productForm.setAdd(false);
		productForm.setProducts(PurchaseBean.getProducts());
		productForm.setTotalPrice(PurchaseBean.getTotalPrice());
		return new ModelAndView("/product/add","productForm",productForm);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("productForm") ProductFormBean productForm) {
		ProductDAO productDao = new ProductDAO();
		Product productItem = new Product();
		productItem = productDao.getById(productForm.getItem()); 
		if (productItem != null){			
			PurchaseBean.addProduct(productItem);
			productForm.setFinalize(false);
			productForm.setAdd(true);
		}else{
			productForm.setMessage(Constants.MESSAGE_PRODUCT_NOT_FOUND);
		}
		productForm.setItem("");		
		productForm.setProducts(PurchaseBean.getProducts());
		productForm.setTotalPrice(PurchaseBean.getTotalPrice());
		
		return new ModelAndView("/product/add","productForm",productForm);
	}
	
	@RequestMapping(value = "/finalize", method = RequestMethod.GET)
	public ModelAndView finalize(@ModelAttribute("productForm") ProductFormBean productForm) {
	  int totalDiscount = 0;			
	  int discount = 0;
	  productForm.setProductsDiscount(new ArrayList<String>());
	  for (Product key : PurchaseBean.getProductDiscount().keySet()) {
          Integer value = PurchaseBean.getProductDiscount().get(key);
          if (value >= key.getQuantityDiscount()){
        	  discount = (value/key.getQuantityDiscount())*key.getDiscount();
	          totalDiscount = totalDiscount + discount;          
	          productForm.getProductsDiscount().add(Constants.MESSAGE_DISCOUNT+key.getDescription()+">>> -"+discount);
          }
	  }
	  productForm.setItem("");
	  productForm.setFinalize(true);
	  productForm.setProducts(PurchaseBean.getProducts());
	  productForm.setTotalPrice(PurchaseBean.getTotalPrice() - totalDiscount);
	  return new ModelAndView("/product/add","productForm",productForm);
	}	
}
