package client;

import java.util.List;
import java.util.Scanner;

import common.pojo.Product;
import service.ProductService;

public class ConsoleApp {

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
	
			default:
				break;
		}
		
		
		
		input.close();
//		searchView();
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

	private void searchView() {

	}

}
