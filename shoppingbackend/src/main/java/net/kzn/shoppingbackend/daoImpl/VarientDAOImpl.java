package net.kzn.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.VarientDAO;
import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.Varient;

@Repository("varientDAO")
@Transactional
public class VarientDAOImpl implements VarientDAO {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public boolean add(Varient varient) {
		try {
			// add the varient to the database table
			sessionfactory.getCurrentSession().persist(varient);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Varient varient) {
		try {
			// update the varient to the database table
			sessionfactory.getCurrentSession().update(varient);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Varient varient) {
		varient.setActive(false);
		try {
			// delete the varient from the database table
			sessionfactory.getCurrentSession().update(varient);

			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Varient get(int varientId) {

		return sessionfactory.getCurrentSession().get(Varient.class, Integer.valueOf(varientId));
	}

	@Override
	public List<Varient> listActiveVarients() {
		String selectActiveVarients = "FROM Varient WHERE active = :active";
		
		return sessionfactory
				.getCurrentSession()
					.createQuery(selectActiveVarients, Varient.class)
						.setParameter("active", true)
							.getResultList();
		
	}

	@Override
	public List<Varient> list() {
		return sessionfactory.getCurrentSession().createQuery("FROM Varient", Varient.class).getResultList();
	}
	
	

}
