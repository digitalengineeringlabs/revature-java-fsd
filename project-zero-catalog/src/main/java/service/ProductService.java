package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Product;
import dao.ProductDAO;

public class ProductService {
	
	private static final Logger logger = LogManager.getLogger(ProductService.class);
	
	private ProductDAO dao = new ProductDAO();
	
	public List<Product> findAll() throws Exception {
		return dao.findAll();
	}
	
	public List<Product> findAll(String title) throws Exception {
		//1. input validation
		if(title == null || title.isEmpty()) {
			throw new IllegalArgumentException("Enter valid title");
		}
		//2. any transformation
		
		//3. business validation
		
		//4. do actual logic
		//logger.trace("performing account validation...");
		
		//5. do any persistence
		
		//6. build response (pojos)
		
		return dao.findAll(title);
	}
	
	public int save(Product p) throws Exception{
		return dao.save(p);
	}
	
	public void	update(int id, String title) {
		
	}
	
	public void	delete(int id) {
		
	}

}
