package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	public static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment = new Date();
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Order() {}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum=0.0;
		for(OrderItem c: items) {
			sum += c.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() 
				+" (" + sdf2.format(client.getBirthDate())+") - " 
				+ client.getEmail() + "\n");
		sb.append("Order items:\n");
		for(OrderItem c: items) {
			sb.append(c.getProduct().getName() +", $"
					+ String.format("%.2f",c.getProduct().getPrice()) +" , "
					+ "Quantity: " + c.getQuantity() + ", "
					+ "Subtotal: $" + String.format("%.2f", c.subTotal()) +"\n");
		}
		double sum = 0.0;
		for(OrderItem c:items) {
			sum += c.subTotal();
		}
		sb.append("Total price: $" + String.format("%.2f", sum));
		return sb.toString();
	}
	
}
