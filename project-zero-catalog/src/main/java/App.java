import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import client.ConsoleApp;

public class App {
	
	private static final Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		
		ConsoleApp console = new ConsoleApp();
		logger.info("Starting Application ...");
		console.start();
		logger.info("Application Exited");
		
	}
}
