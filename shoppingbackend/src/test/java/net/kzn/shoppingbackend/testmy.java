package net.kzn.shoppingbackend;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.daoImpl.CategoryDAPImpl;
import net.kzn.shoppingbackend.dto.Category;

public class testmy {

	public static void main(String[] args) {
		
		
		Category category = new Category();
		
		
		category.setName("Television");
		category.setDescription("This is some description for television ");
		category.setImageUrl("CAT_1.png");
		CategoryDAO categoryDAO = new CategoryDAPImpl();
		System.out.println(categoryDAO.add(category));
		
	}
}
