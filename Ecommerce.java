import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listProducts() {
        System.out.println("Products in Order #" + orderId + ":");
        for (Product product : products) {
            System.out.println(" - " + product.getName() + " (Rs." + product.getPrice() + ")");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public int getOrderId() {
        return orderId;
    }
}

class EcommerceCustomer {
    private String name;
    private List<Order> orders;

    public EcommerceCustomer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        System.out.println(name + "'s Orders:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderId() + " - Total: Rs." + order.calculateTotal());
        }
    }
}

public class Ecommerce {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 1200.00);
        Product phone = new Product("Smartphone", 800.00);
        Product headphones = new Product("Headphones", 150.00);


        EcommerceCustomer naman = new EcommerceCustomer("Manvi Grover");

        // Create orders
        Order order1 = new Order(1);
        order1.addProduct(laptop);
        order1.addProduct(headphones);

        Order order2 = new Order(2);
        order2.addProduct(phone);

        naman.placeOrder(order1);
        naman.placeOrder(order2);

        naman.listOrders();
        order1.listProducts();
        order2.listProducts();
    }
}