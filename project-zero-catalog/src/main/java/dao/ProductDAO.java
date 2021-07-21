package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.pojo.Product;

public class ProductDAO {

	public List<Product> findAll() throws Exception {
		//TODO: temporary - should be fixed with actual SQL call
		List<Product> products = new ArrayList<Product>();
		
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres")){
			PreparedStatement pstmt = conn.prepareStatement("select * from product");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				products.add(p);
			}
		} catch (SQLException ex) {
			throw ex;}
		
		return products;
	}
	
	public List<Product> findAll(String title){
		return null;
	}
	
	public int save(Product p) {
		return 0;
	}
	
	public void	update(int id, String title) {
		
	}
	
	public void	delete(int id) {
		
	}
	
}
