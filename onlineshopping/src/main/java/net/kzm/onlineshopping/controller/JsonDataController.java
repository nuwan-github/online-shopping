package net.kzm.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dao.VarientDAO;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.Varient;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDao;
	
	@Autowired
	private VarientDAO varientDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product>getAllProducts(){
		
		return productDao.listActiveProducts();
	}
	
	@RequestMapping("admin/all/products")
	@ResponseBody
	public List<Product>getAllProductsForAdmin(){
		
		return productDao.list();
	}
	@RequestMapping("admin/all/varient")
	@ResponseBody
	public List<Varient>getAllVarientssForAdmin(){
		
		return varientDAO.list();
	}
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product>getProductByCategory(@PathVariable int id){
		
		return productDao.listActiveProductsByCategory(id);
	}
}

