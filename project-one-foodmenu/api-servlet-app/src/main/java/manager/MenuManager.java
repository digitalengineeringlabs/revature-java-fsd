package manager;

import java.util.List;

import common.model.Menu;
import dao.MenuDao;
import dao.MenuDaoImpl;

public class MenuManager {

	private MenuDao dao = new MenuDaoImpl();
	
	public MenuManager() {
	}
	
	public void create(Menu menu) {
		dao.create(menu);
	}
	
	public List<Menu> findAll() {
		return dao.findAll();
	}

	public static void main(String[] args) {
		List<Menu> menus = new MenuManager().findAll();
		System.out.println(menus);
	}

	public Menu findById(int id) {
		return dao.findById(id);
	}

	public void delete(int id) {
		dao.delete(id);
	}
}
