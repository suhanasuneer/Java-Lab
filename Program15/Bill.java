import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface Billing {
	void addProduct(int productId, String name, int quantity, double unitPrice);
	void generateBill(int orderNumber);
	}
	
class Product {
	int productId;
	String name;
	int quantity;
	double unitPrice;
	
	Product(int productId, String name, int quantity, double unitPrice) {
	this.productId = productId;
	this.name = name;
	this.quantity = quantity;
	this.unitPrice = unitPrice;
	}
	
	double getTotal() {
	return quantity * unitPrice;
	}
	}
	
	class BillGenerator implements Billing {
	List<Product> products = new ArrayList<>();
	
public void addProduct(int productId, String name, int quantity, double unitPrice) {
	products.add(new Product(productId, name, quantity, unitPrice));
	}
public void generateBill(int orderNumber) {
	double subTotal = 0;
	double gstRate = 0.05;
	
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

	System.out.println("\n============================================================");
	System.out.println("                     RETAIL SHOP BILL                        ");
	System.out.println("============================================================");
	System.out.println("Bill No   : " + orderNumber);
	System.out.println("Date      : " + now.format(dateFormat));
	System.out.println("Time      : " + now.format(timeFormat));
	System.out.println("------------------------------------------------------------");
	
	System.out.printf("%-6s %-20s %-6s %-10s %-10s\n",
	"ID", "Product Name", "Qty", "Price", "Total");
	System.out.println("------------------------------------------------------------");
	
	for (Product p : products) {
	double total = p.getTotal();
	subTotal += total;
	
	System.out.printf("%-6d %-20s %-6d %-10.2f %-10.2f\n",
	p.productId, p.name, p.quantity, p.unitPrice, total);
	}
		
	double gst = subTotal * gstRate;
	double grandTotal = subTotal + gst;
	
	System.out.println("------------------------------------------------------------");
	System.out.printf("%-35s : %.2f\n", "Subtotal", subTotal);
	System.out.printf("%-35s : %.2f\n", "GST (5%)", gst);
	System.out.printf("%-35s : %.2f\n", "Grand Total", grandTotal);
	System.out.println("============================================================");
	System.out.println("        THANK YOU! PLEASE VISIT AGAIN 😊");
	System.out.println("============================================================");
	}
	}
public class Bill {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Enter number of orders: ");
	int orders = sc.nextInt();
	sc.nextLine();
	
	List<BillGenerator> allOrders = new ArrayList<>();
	
	for (int o = 1; o <= orders; o++) {
	BillGenerator bill = new BillGenerator();
	
	System.out.print("\nEnter number of products for Order " + o + ": ");
	int n = sc.nextInt();
	sc.nextLine();
	
	for (int i = 0; i < n; i++) {
	System.out.println("\nEnter product " + (i + 1) + " details:");
	
		System.out.print("Product ID: ");
	int id = sc.nextInt();
	sc.nextLine();
	
	System.out.print("Product Name: ");
	String name = sc.nextLine();
	
	System.out.print("Quantity: ");
	int qty = sc.nextInt();
	
	System.out.print("Unit Price: ");
	double price = sc.nextDouble();
	sc.nextLine();
	
	bill.addProduct(id, name, qty, price);
	}
	
	allOrders.add(bill);
	}
	
	int orderNumber = 1;
	for (BillGenerator bill : allOrders) {
	bill.generateBill(orderNumber++);
	}
	
	sc.close();
	}
	}		
