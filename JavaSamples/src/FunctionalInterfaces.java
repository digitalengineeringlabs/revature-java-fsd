import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		
//		Calc c = new Calc();
//		c.calculate(2)

		Square s = (int input) -> {
			return input * input;
		};
		
		int result = s.calculate(9);
		System.out.println(result);
		
		//Built-in Functional Interfaces
		
		//Predicate
		//Binary Operator
		//Function
		
		Predicate<String> check = (str) -> { return str.startsWith("Mr.");};
		
		boolean result2 = check.test("Mr.President");
		
		
		Function<User,Manager> m = (User u)->{ return new Manager(null,0,false);};
		
		Function<Integer,Double> fn = (Integer a) -> { return a/2.0;};
		//auto-boxing
//		int a = 3;
//		Integer aObj = new Integer(a);
		double result3 = fn.apply(4);
		
	}
	
}



//class Calc implements Square {
//
//	@Override
//	public int calculate(int input) {
//		return input * input;
//	}
//	
//}

//Annotations

@FunctionalInterface
interface Square {
	int calculate(int input);
}
