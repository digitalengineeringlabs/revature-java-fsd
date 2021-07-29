
public class Address {
	
	private int id;
	private String street;
	private String zip;

	//private int employee_id;
	private Employee employee; //many-to-one
	
	public Address() {
	}

	public Address(String street, String zip) {
		super();
		this.street = street;
		this.zip = zip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
