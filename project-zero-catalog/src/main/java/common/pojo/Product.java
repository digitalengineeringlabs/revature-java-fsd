package common.pojo;

public class Product {
	
	private int id;
	private String title;
	private String category;
	private double price;
	
	public Product() {
		super();
	}

	public Product(String title) {
		super();
		this.title = title;
	}

	public Product(int id, String title, String category, double price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}
