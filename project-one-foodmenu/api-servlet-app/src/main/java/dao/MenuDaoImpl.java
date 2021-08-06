package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.model.Menu;
import common.util.DBUtil;

public class MenuDaoImpl implements MenuDao {

	@Override
	public void create(Menu menu) {
		
		Session session = DBUtil.getInstance().getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(menu);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(tx != null) {
				tx.rollback();
			}
		}
		
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findAll() {

		Session session = DBUtil.getInstance().getSession();
		
		Query query = session.createQuery("FROM common.model.Menu");

		List<Menu> menus = query.list();
		
		session.close();

		return menus;
	}

}
