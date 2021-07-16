import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator calc = null;
	
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("called in before class");
	}
	
	
	@Before
	public void beforeTest(){
		calc = new Calculator();
	}
	
	@Test
	public void evaluateExpressionRightValues(){
		
		//testing the evaluate
		//success
		//fail
		//Calculator calc = new Calculator();
		int sum = calc.evaluate("2+4+8");
		
		assertEquals(14, sum);
	}
	
	@Test
	public void evaluateExpressionWrongValues(){
		
		//testing the evaluate
		//success
		//fail
		//Calculator calc = new Calculator();
		int sum = calc.evaluate("2+4+8");
		
		assertNotEquals(12, sum);
	}
	
	@After
	public void afterTest() {
		System.out.println("clean any resources...");
	}
}
