import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
	
	public static void main(String[] args) {
		
		//1. create connection
		try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres")) {	
		
			//2. get Statement object
			Statement stmt = conn.createStatement();
			
			//3. get resultset object
			ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
			
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
