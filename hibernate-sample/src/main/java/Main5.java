import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main5 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// SessionFactory from Configuration
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Session
		Session session = factory.openSession();
		
		String hql = "FROM Project";
		Query<Project> query = session.createQuery(hql);
		
		List<Project> projects = query.list();
		for(Project p : projects) {
			System.out.println(p.getTitle());
//			Set<Task> tasks = p.getTasks();
//			System.out.println(tasks.size());
		}
		
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//		
//			Project p = new Project("Project 3",new Date());
//			session.save(p);
//			
//			Task t = new Task("Task 3", "NEW",new Date());
//			t.setProject(p);
//			
//			session.save(t);
//			
//			tx.commit();
//			System.out.println("Saved");
//		}catch(Exception e) {
//			 if (tx!=null) tx.rollback();
//			e.printStackTrace();
//		}
		
		/* Named Query */
//		 Query query2 = session.getNamedQuery("findProjectByID").setParameter("id", 13);
//		 List<Project> projects1 = query2.list();
//			for(Project p : projects1) {
//				System.out.println(p.getTitle());
//			}
//			
		/* Native SQL */
		Query query3 = session.createNativeQuery("SELECT id, title, begin_date FROM sample.project");

//		Query query3 = session.createNativeQuery("SELECT id, title, begin_date FROM sample.project").addEntity(Project.class);
			
			List<Object[]> rows = query3.getResultList();
			for(Object[] row : rows) {
				for(Object cell : row) {
					System.out.println(cell);
				}
			}
	}

}
