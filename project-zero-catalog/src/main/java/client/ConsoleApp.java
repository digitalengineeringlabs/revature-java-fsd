package client;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import common.pojo.Product;
import dao.ProductDAO;
import service.ProductService;

public class ConsoleApp {
	
	private static final Logger logger = LogManager.getLogger(ConsoleApp.class);

	private ProductService service = new ProductService();

	public void start() {
		
		boolean quit = false;
		
		Scanner input = new Scanner(System.in);

		do {
			// show menu
			showMenu();
			
			System.out.println("Enter Action: ");
			String choice = input.next();
			
			switch (choice) {
				case "1":
					listView();
					break;
				case "2":
					searchView(input);
					break;
				case "3":
					addView(input);
					break;
				case "6":
					quit = true;
					break;
				default:
					break;
			}
		} while(!quit);
		
		input.close();
		
		System.out.println("Exited.");

//		updateView();
//		deleteView();

	}

	private void addView(Scanner input) {
		
		String title = getInput("Title:",input);
		String category = getInput("Category:",input);
		String price = getInput("Price: ",input); 
		//TODO: handle invalid input (for ex: alphabets in price)
		Product product = new Product(0,title,category,Double.parseDouble(price));
		try {
			service.save(product);
			System.out.println("Added Product");
		} catch (Exception e) {
			System.out.println("Error: unable to save :"+e.getMessage());
			logger.error(e);
		}
		
	}

	private String getInput(String prompt, Scanner input) {
		System.out.println(prompt);
		return input.next();
	}

	private void showMenu() {
		System.out.println("1.List");
		System.out.println("2.Search");
		System.out.println("3.Add");
		System.out.println("4.Update");
		System.out.println("5.Delete");
		System.out.println("6.Quit");
	}

	private void listView() {

		try {
			List<Product> products = service.findAll();
			printList(products);
		} catch (Exception e) {
			System.err.println("System Error: "+e.getMessage());
		}

	}

	private void searchView(Scanner input) {
		
		System.out.println("Enter title to search: ");
		String title = input.next();
		
		//TODO: do some sanity check (regex)
		
		try {
			List<Product> products = service.findAll(title);
			printList(products);
		} catch (Exception e) {
			System.err.println("System Error: "+e.getMessage());
		}
	}

	private void printList(List<Product> products) {
		// header
		System.out.println("ID | Title | Category | Price");
		// data
		for (Product p : products) {
			System.out.println(p.getId() + " | " + p.getTitle() + " | " + p.getCategory() + " | $" + p.getPrice());
		}
	}

}
