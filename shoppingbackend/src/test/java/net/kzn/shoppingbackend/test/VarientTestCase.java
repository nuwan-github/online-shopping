package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dao.VarientDAO;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.Varient;



public class VarientTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static VarientDAO varientDAO;
	
	private static ProductDAO productDAO;
	
	
	private static Varient varient;
	
	private static Product product;
	
	
	@BeforeClass
	public static void init(){
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		
		varientDAO = (VarientDAO) context.getBean("varientDAO");
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	/*@Test
	public void testAddVarient(){
		varient= new Varient();
		
		product = productDAO.get(1);
		varient.setProductId(2);
		varient.setColor("Gray");
		varient.setMadeBy("China");
		varient.setSize(15.5);
		
		assertEquals("Something went wrong while inserting a Varient", true, varientDAO.add(varient));
	}
	*/
	/*@Test
	public void testGetVarient(){
		varient =varientDAO.get(1);
		
		assertEquals("Some thing went wrong while fetches a single varient from the table", "Gray",varient.getColor());
	}
	*/
	/*@Test
	public void testUpdateVarient(){
		varient =varientDAO.get(1);
		varient.setActive(true);
		
		assertEquals("Some thing went wrong while Updating a product",true,varientDAO.update(varient));
	}*/
	/*@Test
	public void testDeleteVarient(){
		varient =varientDAO.get(1);

		
		assertEquals("Some thing went wrong while Deleting a varient",true,varientDAO.delete(varient));
	}*/
	
	/*@Test
	public void testGetListOfActiveVarient(){
		
		
		assertEquals("Some thing went wrong while get List Of Varient from the table", 1,varientDAO.listActiveVarients().size());
	}*/
	
	@Test
	public void testGetListOfvarient(){
		
		
		assertEquals("Some thing went wrong while get List Of varient from the table", 11,varientDAO.list().size());
	}
	
}
