package net.kzn.shoppingbackend.dao;

import java.util.List;

import net.kzn.shoppingbackend.dto.Product;
import net.kzn.shoppingbackend.dto.Varient;

public interface VarientDAO {

	Varient get(int varientId);
	
	boolean add(Varient varient);

	boolean update(Varient varient);

	boolean delete(Varient varient);
	
	List<Varient> list();
	
	//business methods
	List<Varient> listActiveVarients();
	
}
