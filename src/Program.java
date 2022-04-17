import entities.Customer;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import util.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Enter customer data-----");
        System.out.print("Name: ");
        String custName = scanner.nextLine();
        System.out.print("Email: ");
        String custEmail = scanner.nextLine();
        System.out.print("Birth Date: ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date custBirth = sdf.parse(scanner.nextLine());
        Customer customer=new Customer(custName, custEmail, custBirth);

        System.out.println("-----Enter Order Data-----");
        Order order = new Order(new Date(), OrderStatus.PENDING_PAYMENT, customer);
        System.out.print("How many itens to this order? ");
        int quantityItems = scanner.nextInt();
        for (int n = 0; n < quantityItems; n++){
            System.out.print("Enter the product "+(n+1)+": ");
            scanner.nextLine();
            String prodName = scanner.nextLine();
            System.out.print("Price: ");
            Double prodPrice = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quant = scanner.nextInt();
            Product product = new Product(prodName, prodPrice);
            OrderItem orderItem = new OrderItem(quant, prodPrice, product);
            order.addItems(orderItem);
        }
        System.out.println(order);

    }
}
