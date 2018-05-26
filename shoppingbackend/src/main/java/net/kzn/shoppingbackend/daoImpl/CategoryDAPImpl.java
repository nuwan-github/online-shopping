package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAPImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionfactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	/*
	 * getting single category based on the id
	 * 
	 */
	@Override
	public Category get(int id) {

		return sessionfactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		
		try {
			// add the category to the database table
			sessionfactory.getCurrentSession().persist(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * update a single category
	 *
	 */
	@Override
	public boolean update(Category category) {
		try {
			// add the category to the database table
			sessionfactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			// add the category to the database table
			sessionfactory.getCurrentSession().update(category);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * private static List<Category> categories = new ArrayList();
	 * 
	 * static {
	 * 
	 * Category category; first category category = new Category();
	 * category.setId(1); category.setName("Television");
	 * category.setDescription("This is some description for television ");
	 * category.setImageUrl("CAT_1.png"); categories.add(category);
	 * 
	 * second category category = new Category(); category.setId(2);
	 * category.setName("Mobile");
	 * category.setDescription("This is some description for mobile ");
	 * category.setImageUrl("CAT_2.png"); categories.add(category);
	 * 
	 * first category category = new Category(); category.setId(3);
	 * category.setName("Laptop");
	 * category.setDescription("This is some description for laptop");
	 * category.setImageUrl("CAT_3.png"); categories.add(category);
	 * 
	 * first category category = new Category(); category.setId(4);
	 * category.setName("Palmtop");
	 * category.setDescription("This is some description for Palmtop ");
	 * category.setImageUrl("CAT_4.png"); categories.add(category);
	 * 
	 * }
	 */

}
