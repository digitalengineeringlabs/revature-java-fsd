package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Product;
import common.util.DBUtil;
import service.ProductService;

public class ProductDAO {
	
	private static final Logger logger = LogManager.getLogger(ProductDAO.class);

	public List<Product> findAll() throws Exception {
		return findAll(null);
	}

	private boolean isTitlePresent(String title) {
		return title != null && !title.isEmpty();
	}

	public List<Product> findAll(String title) throws Exception {
		
		// TODO: temporary - should be fixed with actual SQL call
		List<Product> products = new ArrayList<Product>();

		try {
			Connection conn = DBUtil.getInstance().getConnection();

			String query = "select * from product";
			if (isTitlePresent(title)) {
				query += " where title = ?";
			}

			PreparedStatement pstmt = conn.prepareStatement(query);

			if (isTitlePresent(title)) {
				pstmt.setString(1, title);
			}

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
				products.add(p);
			}
		} catch (SQLException ex) {
			throw ex;
		}

		return products;
	}

	public int save(Product p) throws Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("insert into product (title,category,price) values (?,?,?)");

		pstmt.setString(1, p.getTitle());
		pstmt.setString(2, p.getCategory());
		pstmt.setDouble(3, p.getPrice());
		
		int inserted = pstmt.executeUpdate();
		
		return inserted;
	}

	public void update(int id, String title) {

	}

	public void delete(int id) {

	}

}
