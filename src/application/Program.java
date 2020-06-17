package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.next();
		System.out.print("Email: ");
		sc.nextLine();
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY):");
		String birhtDate = sc.next();
		
		Client client = new Client(clientName,email,sdf2.parse(birhtDate));
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		
		
		Order order = new Order(new Date(),OrderStatus.valueOf(status),client);
		
		System.out.print("How many orders to this order? ");
		int n = sc.nextInt();
		
		for(int i =1; i<=n; i++) {
			System.out.println("Enter #"+ i + " item data");
			System.out.print("Product name: ");
			String name = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(name,price);
			
			OrderItem item = new OrderItem(quantity,price,product);
			order.addItem(item);
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}

}
