package pojo;

public class Member {
	
	private String name;
	//private Group group;
	private double score;

	public Member(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.getName().equals(((Member)obj).getName());
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
	    hash = 31 * hash + (name == null ? 0 : name.hashCode());
	    return hash;
	}
	
}
