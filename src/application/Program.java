package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter client data:");
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Email: ");
			String email = sc.nextLine();
			
			System.out.print("Birth date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());
			
			Client client = new Client(name, email, birthDate);
			
			System.out.println("Enter order data:");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());
			System.out.print("How many items to this order? ");
			int n = sc.nextInt();
			Order order = new Order(new Date(), status, client);
			for(int i=0;i<n;i++) {
				System.out.println("Enter #"+(i+1)+" item data:");
				System.out.print("Product name: ");
				String itemName = sc.nextLine();
				sc.next();
				System.out.print("Product price: ");
				double itemPrice = sc.nextDouble();
				System.out.print("Quantity: ");
				int itemQuantity = sc.nextInt();
				Product product = new Product(itemName, itemPrice);
				OrderItem item = new OrderItem(itemQuantity, itemPrice, product);				
				
				order.addItem(item);
			}
			System.out.println(order);
		}

	}

}
