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


		String configLocation = "/Volumes/Data HD/Workspace/sts2/sample-maven/src/main/resources/config.properties";
	
		try (FileInputStream fileStream = new FileInputStream(configLocation)){
			
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
			
				//conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
				insertData(conn);
				
				readData(conn);

				callFunction(conn);
			
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		} catch (Exception ex) {ex.printStackTrace();}
	}
	
	static void callFunction(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select sample.add(4,2)");
		rs.next();
		System.out.println(rs.getInt(1));
	}

	static void insertData(Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee (name,gender) VALUES (?,?)");	
		pstmt.setString(1, "Johnson");
		pstmt.setString(2, "M");
		int inserted1 = pstmt.executeUpdate();
		System.out.println("inserted: "+inserted1);
	}
	
	static void readData(Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employee WHERE gender = ?");
		pstmt.setString(1, "M");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			String name = rs.getString("name");
			System.out.println(name);
		}
	}

}
