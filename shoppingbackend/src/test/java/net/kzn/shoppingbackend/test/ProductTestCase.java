package net.kzn.shoppingbackend.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDao;
	
	private static Product product;
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		productDao = (ProductDAO) context.getBean("productDAO");
		
	}
	
/*	@Test
	public void testAddProduct(){
		product = new Product();
		
		product.setName("KeyBoard");
		product.setBrand("A4tech");
		product.setDescription("Best brand for keyboard");
		product.setUnitprice(5500);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
	
		
		assertEquals("Something went wrong while inserting a productes", true, productDao.add(product));
	}*/
	@Test
	public void testGetProduct(){
		product = productDao.get(33);
		
		assertEquals("Some thing went wrong while fetches a single product from the table", "aa",product.getName());
	}
	/*@Test
	public void testUpdateProduct(){
		product =productDao.get(33);
		product.setBrand("EWis");
		
		assertEquals("Some thing went wrong while Updating a product",true,productDao.update(product));
	}*/
/*	@Test
	public void testDeleteProduct(){
		product =productDao.get(33);

		
		assertEquals("Some thing went wrong while Deleting a product",true,productDao.delete(product));
	}*/
	
	/*@Test
	public void testGetListOfProduct(){
		
		
		assertEquals("Some thing went wrong while get List Of product from the table", 8,productDao.list().size());
	}*/
	
/*	@Test
	public void testGetListOfActiveProduct(){
		
		
		assertEquals("Some thing went wrong while get List Of product from the table", 7,productDao.listActiveProducts().size());
	}*/
	/*@Test
	public void testGetListOfProductByCategory(){
		
		assertEquals("Some thing went wrong while get List Of product by category from the table", 6,productDao.listActiveProductsByCategory(3).size());
	}*/
/*	@Test
	public void testGetListOfLatestProduct(){
		
		assertEquals("Some thing went wrong while get List Of latest product  from the table", 4,productDao.getLatestActiveProducts(4).size());
	}*/
	
	
}
