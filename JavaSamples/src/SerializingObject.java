import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializingObject {
	
	public static void main(String[] args) {
		
		Manager m1 = new Manager("Mike",34,true);
		
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
			oos.writeObject(m1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (Exception ignored) {}
		}
		
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("object.txt"));
			System.out.println("reading object fro stream..");
			Manager m2 = (Manager) ois.readObject();
			System.out.println(m2.name);
			System.out.println(m2.age);
			System.out.println(m2.senior);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException ignored) {}
		}
		
	}

}

class Manager implements Serializable {
	
	String name;
	int age;
	boolean senior;
	
	public Manager(String name, int age, boolean senior) {
		this.name = name;
		this.age = age;
		this.senior = senior;
	}
}
