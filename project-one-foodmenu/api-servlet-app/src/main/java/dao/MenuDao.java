package dao;

import java.util.List;

import common.model.Menu;

public interface MenuDao {

	public void create(Menu menu);
	
	public List<Menu> findAll();

	public Menu findById(int id);

	public void delete(int id);

}
