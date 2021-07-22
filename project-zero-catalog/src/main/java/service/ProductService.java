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
		return dao.findAll(title);
	}
	
	public int save(Product p) {
		return 0;
	}
	
	public void	update(int id, String title) {
		
	}
	
	public void	delete(int id) {
		
	}

}
