import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(2,3,4,5,7);//new ArrayList<Integer>();
		//List<String> names = Arrays.asList("Mike","John");//new ArrayList<Integer>();
		
		//map, filter, sorted (intermediate operations or pipeline)
		//collect, forEach, reduce (terminal operations)
		
		List<Integer> result = numbers.stream().filter(x -> x % 2 == 0).map((x)->{return x * x;}).collect(Collectors.toList());
		//names.stream().map((x)->{ return "Mr. "+x;});
		
		for(Integer i : result) {
			System.out.println(i);
		}
	}
}
