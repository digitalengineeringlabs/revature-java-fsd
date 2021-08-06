package common.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="menu")
public class Menu implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "menu_id_seq", allocationSize = 1)
	private int id;

	@Column
	private String title;
	
	@Column(name="begin_date")
	private Date beginDate;

	public Menu() {
		super();
	}

	public Menu(String title, Date beginDate) {
		super();
		this.title = title;
		this.beginDate = beginDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	@Override
	public String toString() {
		return "[" + this.title + "," + this.beginDate + "]";
	}
}
