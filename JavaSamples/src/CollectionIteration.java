import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CollectionIteration {
	
	public static void main(String[] args) {
		
		List<String> fruits = new ArrayList<String>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Citrus");
		
		//Iterator
		Iterator<String> iter = fruits.iterator();
		while(iter.hasNext()) {
			String fruit = iter.next();
			System.out.println(fruit);
		}
		
		//Iterable - 1.8
		fruits.forEach((element) -> {System.out.println(element);});
		
		
	}
}
