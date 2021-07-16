import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
	
	private static final Logger logger = LogManager.getLogger(Calculator.class);

	//1+4+7 = 12
	//4*3/5
	public int evaluate(String expression){
		
		//log "calculating expression"
		//TRACE
		logger.trace("trace level log");
		//DEBUG
		logger.debug("calculating expression");
		//INFO
		logger.info("info level");
		//WARN
		//ERROR
		
		
		int sum = 0;
		String[] arr = expression.split("\\+");
		for(String val : arr) {
			sum += Integer.valueOf(val);
		}
		return sum;
	}
	
}
