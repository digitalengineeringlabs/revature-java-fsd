import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		//SessionFactory from Configuration
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Session
		Session session = factory.openSession();
		
		//use session for querying and other operations
		Employee emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getGender());
		
		session.close();
	}

}
