import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcExample {
	
	public static void main(String[] args) {
		// "jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres"

	
		try (FileInputStream fileStream = new FileInputStream("/Volumes/Data HD/Workspace/sts2/sample-maven/src/main/resources/config.properties")){
			
			//load the properties file
			Properties props = new Properties();
			props.load(fileStream);
		
			String URL = (String) props.get("db_url");
			String USERNAME = (String) props.get("db_user");
			String PASSWORD = (String) props.get("db_password");

			System.out.println(URL);
			System.out.println(USERNAME);
			System.out.println(PASSWORD);
			
			//1. create connection
			try (Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {	
			
				//2. get Statement object
				//Statement stmt = conn.createStatement();
	//			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee (name,gender) VALUES (?,?)");
	//			
	//			pstmt.setString(1, "Johnson");
	//			pstmt.setString(2, "M");
	//			
	//			int inserted1 = pstmt.executeUpdate();
	//			System.out.println("inserted: "+inserted1);
	
				
				//3. get resultset object
				//PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM employee WHERE gender = ?");
				//readData(pstmt2);
	//			Statement stmt = conn.createStatement();
	//			int inserted2 = stmt.executeUpdate("INSERT INTO employee (name,gender) VALUES ('Christina','F')");
	//			System.out.println("inserted: "+inserted2);
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select sample.add(4,2)");
				rs.next();
				System.out.println(rs.getInt(1));
			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		} catch (Exception ex) {ex.printStackTrace();}
	}
	
	static void readData(PreparedStatement pstmt) throws SQLException {
		pstmt.setString(1, "M");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			System.out.println(name);
		}

	}

}
