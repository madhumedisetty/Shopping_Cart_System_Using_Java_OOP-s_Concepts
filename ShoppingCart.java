package ShoppingCart;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Interface for applying discounts
interface Discount {
    double applyDiscount(double price);
}

// Abstract base class for all products
abstract class Product {
    private String name;
    private double price;

    // Constructor for Product
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to calculate discount
    public abstract double calculateDiscount();

    // Apply discount to the price
    public double applyDiscount(double price) {
        return price - calculateDiscount();
    }
}

// Electronics product class
class Electronics extends Product {
    private int warrantyYears;

    // Constructor for Electronics
    public Electronics(String name, double price, int warrantyYears) {
        super(name, price);
        this.warrantyYears = warrantyYears;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount for electronics
    }
}

// Clothing product class
class Clothing extends Product {
    private int size;

    // Constructor for Clothing
    public Clothing(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount for clothing
    }
}

// User class to store user information
class User {
    private String userName;
    private String password;

    // Constructor for User
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUsername() {
        return userName;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}

// Cart class to manage products in the shopping cart
class Cart {
    private List<Product> products;

    // Constructor for Cart
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Add a product to the cart
    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to cart.");
    }

    // Display all products in the cart
    public void showCart() {
        System.out.println("Cart: ");
        for (Product product : products) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " (Discounted Price: $" + product.applyDiscount(product.getPrice()) + ")");
        }
    }

    // Calculate total price of all products in cart
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.applyDiscount(product.getPrice());
        }
        return totalPrice;
    }
}

// Order class to handle order placement
class Order {
    private Cart cart;
    private User user;

    // Constructor for Order
    public Order(Cart cart, User user) {
        this.cart = cart;
        this.user = user;
    }

    public double getTotalPrice() {
        return cart.calculateTotalPrice();
    }

    // Place the order and display details
    public void placeOrder() {
        System.out.println(user.getUsername() + " placed an order.");
        cart.showCart();
        System.out.println("Total Price: $" + getTotalPrice());
    }
}

// Abstract Payment class
abstract class Payment {
    public abstract void pay(double amount);
}

// Credit Card payment method
class CreditCardPayment extends Payment {
    private String cardNumber;

    // Constructor for CreditCardPayment
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
}

// PayPal payment method
class PayPalPayment extends Payment {
    private String email;

    // Constructor for PayPalPayment
    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// Main ShoppingCart class
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user credentials
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        
        // Create user and cart objects
        User u1 = new User(username, password);
        Cart c1 = new Cart();

        System.out.println("Welcome to the Shopping Cart!");

        // Main program loop
        while (true) {
            // Display menu and get user choice
            System.out.println("Select an action: \n1. Add Product to Cart \n2. View Cart \n3. Place Order \n4. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // Add product to cart
                    System.out.println("Enter product name: ");
                    String name = scanner.next();
                    System.out.println("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter product category: 1. Electronics 2. Clothing");
                    int category = scanner.nextInt();
                    if (category == 1) {
                        System.out.println("Enter warranty years: ");
                        int warrantyYears = scanner.nextInt();
                        Product product = new Electronics(name, price, warrantyYears);
                        c1.addProduct(product);
                    } else if (category == 2) {
                        System.out.println("Enter size: ");
                        int size = scanner.nextInt();
                        Product product = new Clothing(name, price, size);
                        c1.addProduct(product);
                    } else {
                        System.out.println("Invalid category");
                    }
                    break;
                case 2:
                    // View cart
                    c1.showCart();
                    break;
                case 3:
                    // Place order and process payment
                    Order o1 = new Order(c1, u1);
                    o1.placeOrder();
                    System.out.println("Select payment method: \n1. Credit Card \n2. PayPal");
                    int paymentMethod = scanner.nextInt();
                    if (paymentMethod == 1) {
                        System.out.println("Enter card number: ");
                        String cardNumber = scanner.next();
                        Payment payment = new CreditCardPayment(cardNumber);
                        payment.pay(o1.getTotalPrice());
                    } else if (paymentMethod == 2) {
                        System.out.println("Enter email: ");
                        String email = scanner.next();
                        Payment payment = new PayPalPayment(email);
                        payment.pay(o1.getTotalPrice());
                    }
                    break;
                case 4:
                    // Exit program
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}