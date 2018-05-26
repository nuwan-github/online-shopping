package net.kzm.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.cnr.onlineshopping.validator.ProductValidator;
import net.kzm.onlineshopping.util.fileUploadUtility;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dao.VarientDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.Varient;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private VarientDAO varientDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Product");

		Product nProduct = new Product();
		// set few of the fields
		nProduct.setSupplierId(1);
		nProduct.setActive(true);

		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!!");
			} else if (operation.equals("category")) {
				mv.addObject("message", "Category submission Successfully");
			}
		}

		return mv;

	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView showManageProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Product");

		Product nProduct = productDAO.get(id);

		mv.addObject("product", nProduct);

		return mv;

	}

	@RequestMapping(value = "/product/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {

		Product product = productDAO.get(id);

		boolean isActive = product.isActive();

		// activating and deactivation based on the value of active field
		product.setActive(!product.isActive());

		productDAO.update(product);

		return (isActive) ? "You have succesfully deactivated the product with id " + product.getId()
				: "You have succesfully activated the product with id" + product.getId();
	}

	// handle categorysubmission
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/manage/products?operation=category";
	}

	// return categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	}

	@ModelAttribute("category")
	public Category getCategory() {

		return new Category();
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {

		// product validator check wether image file format valid or not
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}

		// check if there are any error

		if (results.hasErrors()) {
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation Failed for the Submission!!!");
			return "page";
		}
		logger.info(mProduct.toString());

		if (mProduct.getId() == 0) {
			productDAO.add(mProduct);
		} else {
			productDAO.update(mProduct);
		}
		// file upload for each product
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			fileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "/varient", method = RequestMethod.GET)
	public ModelAndView showManageVarients(@RequestParam(name = "operation", required = false) String operation) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageVarients", true);
		mv.addObject("title", "Manage Varient");

		
		Varient nvarient = new Varient();
		nvarient.setActive(true);
		mv.addObject("varient", nvarient);

		if (operation != null) {
			if (operation.equals("varient")) {
				mv.addObject("message", "Varient Submitted Successfully!!");
			}
		}

		return mv;

	}

	// return Products for all the request mapping
	@ModelAttribute("products")
	public List<Product> getProducts() {

		return productDAO.listActiveProducts();
	}

	@RequestMapping(value = "/varient", method = RequestMethod.POST)
	public String handleVarientSubmission(@Valid @ModelAttribute("varient") Varient mvarient, BindingResult results,
			Model model) {
		
		
		
		// check if there are any error
			if (results.hasErrors()) {
					model.addAttribute("userClickManageVarients", true);
					model.addAttribute("title", "Manage Varient");
					model.addAttribute("message", "Validation Failed for the Submission!!!");
					return "page";
				}
			
			
			if (mvarient.getId() == 0) {
				varientDAO.add(mvarient);
			} 
			else {
				varientDAO.update(mvarient);
			}
			
		return "redirect:/manage/varient?operation=varient";

	}
	@RequestMapping(value = "/{id}/varient", method = RequestMethod.GET)
	public ModelAndView showManageVarient(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("userClickManageVarients", true);
		mv.addObject("title", "Manage Varient");

		Varient mVarient = varientDAO.get(id);

		mv.addObject("varient", mVarient);

		
		return mv;

	}
	
	@RequestMapping(value = "/varient/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handleVarientActivation(@PathVariable int id) {

		Varient varient = varientDAO.get(id);

		boolean isActive = varient.isActive();

		// activating and deactivation based on the value of active field
		varient.setActive(!varient.isActive());

		varientDAO.update(varient);

		return (isActive) ? "You have succesfully deactivated the Varient with id " + varient.getId()
				: "You have succesfully activated the Varient with id" + varient.getId();
	}

}
