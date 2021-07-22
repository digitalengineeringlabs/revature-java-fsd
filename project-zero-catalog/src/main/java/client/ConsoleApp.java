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

		// show menu
		showMenu();
		
		System.out.println("Enter Action: ");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		
		switch (choice) {
			case "1":
				listView();
				break;
			case "2":
				searchView(input);
				break;
			default:
				break;
		}
		
		input.close();

//		addView();
//		updateView();
//		deleteView();

	}

	private void showMenu() {
		System.out.println("1.List");
		System.out.println("2.Search");
		System.out.println("3.Add");
		System.out.println("4.Update");
		System.out.println("5.Delete");
	}

	private void listView() {

		try {
			List<Product> products = service.findAll();
			// header
			System.out.println("ID | Title | Category | Price");
			// data
			for (Product p : products) {
				System.out.println(p.getId() + " | " + p.getTitle() + " | " + p.getCategory() + " | $" + p.getPrice());
			}
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
			// header
			System.out.println("ID | Title | Category | Price");
			// data
			for (Product p : products) {
				System.out.println(p.getId() + " | " + p.getTitle() + " | " + p.getCategory() + " | $" + p.getPrice());
			}
		} catch (Exception e) {
			System.err.println("System Error: "+e.getMessage());
		}
	}

}
