import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User u1 = new User("Mike",30);
		User u2 = new User("Kevin",32);
		User u3 = new User("Barb",25);

		List<User> users = new ArrayList<User>();
		users.add(u1);
		users.add(u2);
		users.add(u3);

		//Comparator
		//Collections.sort(users, new NameComparator());

		//Comparable
		Collections.sort(users);

		for(User u : users) {
			System.out.println(u);
		}
	}

}

class NameComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		//-1
		//0
		//1
		return o1.name.compareTo(o2.name);
	}
	
}

class User implements Comparable<User> {

	String name = null;
    int age = 0;
	
	//constructor
    public User(String name, int age) {
    	this.name = name;
    	this.age = age;
    }
    
    @Override
    public String toString() {
    	return "["+this.name +", "+ this.age +"]";
    }

	@Override
	public int compareTo(User otherObj) {
		//User otherObj = (User) o;
		return this.name.compareTo(otherObj.name);
	}
} 