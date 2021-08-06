package dao;

import java.util.List;

import org.hibernate.HibernateException;
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
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;// new RuntimeException(e.getCause());
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

	@Override
	public Menu findById(int id) {
		Session session = DBUtil.getInstance().getSession();

		Query query = session.createQuery("FROM common.model.Menu where id = :id");
		query.setInteger("id", id);
		
		Menu menu = (Menu) query.uniqueResult();

		session.close();

		return menu;
	}

	@Override
	public void delete(int id) {
		Session session = DBUtil.getInstance().getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Menu.class, new Integer(id)));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;// new RuntimeException(e.getCause());
		}

		session.close();
	}

}
