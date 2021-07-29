import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		
		//SessionFactory from Configuration
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Session
		Session session = factory.openSession();
		
		//use session for querying and other operations
		
		getUniqueRecord(session);
		getAllRecords(session);
		filterRecords(session);
		
		createRecord(session); 
		updateRecord(session); 
		deleteRecord(session); 
		
		session.close();
	}

	private static void deleteRecord(Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Employee emp = (Employee) session.get(Employee.class, 30);
					
			session.delete(emp);

			tx.commit();
			System.out.println("Employee deleted");
		 } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	}
	
	private static void updateRecord(Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			
			Employee emp = (Employee) session.get(Employee.class, 30);
			emp.setGender("F");			
			session.update(emp);

			tx.commit();
			System.out.println("Employee updatd");
		 } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
	}

	private static Transaction createRecord(Session session) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee newEmp = new Employee("Will","M");
			int id = (Integer) session.save(newEmp);
			tx.commit();
			System.out.println("New employee ID: "+id);
		 } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }
		return tx;
	}

	private static void filterRecords(Session session) {
		Query query = session.createQuery("FROM Employee WHERE location = :loc");
		query.setString("loc", "Austin");
		
		List<Employee> employees = query.list();
		
		for(Employee e : employees) {
			System.out.println(e.getName()+ " | " +e.getGender());
		}
	}

	private static void getAllRecords(Session session) {
		List<Employee> employees = session.createQuery("FROM Employee").list();
		
		for(Employee e : employees) {
			System.out.println(e.getName()+ " | " +e.getGender());
		}
	}

	private static void getUniqueRecord(Session session) {
		Employee emp = (Employee) session.get(Employee.class, 1);
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getGender());
	}

}
