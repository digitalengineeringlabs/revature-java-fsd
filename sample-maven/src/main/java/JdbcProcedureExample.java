import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcProcedureExample {
	
	public static void main(String[] args) {
		
		try(Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres")){
			
			CallableStatement cstmt = conn.prepareCall("call sample.enroll_employee(?,?)");
			cstmt.setString(1,"Roger");  
			cstmt.setString(2,"M");  
			cstmt.execute();  
			System.out.println("Done");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
