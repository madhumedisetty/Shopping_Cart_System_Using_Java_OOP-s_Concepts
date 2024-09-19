# Shopping_Cart_System_Using_Java_OOP-s_Concepts

## Overview

The Online Shopping System is a Java-based application that allows users to browse products, add them to a cart, and make purchases. This project demonstrates key object-oriented programming concepts such as classes, inheritance, polymorphism, encapsulation, abstraction, and interfaces.

## Key Features

- **User Authentication**: Users can create accounts and log in to manage their shopping activities.
- **Product Management**: Users can add different types of products (Electronics, Clothing) to their cart.
- **Shopping Cart**: Users can view their cart and see the total price with applicable discounts.
- **Order Placement**: Users can place orders and choose between different payment methods (Credit Card, PayPal).

## Concepts Covered

### 1. Classes & Objects
- **Product Class**: An abstract class representing general product attributes and methods.
- **Electronics & Clothing Classes**: Subclasses of `Product` that inherit its properties and methods, with added specific attributes.

### 2. Inheritance
- The `Electronics` and `Clothing` classes extend the `Product` class, allowing them to inherit common properties and methods while also defining their unique characteristics.

### 3. Polymorphism
- The `calculateDiscount()` method is overridden in the `Electronics` and `Clothing` classes to provide specific discount calculations for each product type.

### 4. Encapsulation
- Sensitive user data, such as passwords, is kept private within the `User` class. Access is provided through secure methods like `checkPassword()`.

### 5. Abstraction
- The `Payment` class is an abstract class that defines a method `pay()`. Subclasses like `CreditCardPayment` and `PayPalPayment` implement this method, providing specific payment processing functionalities.

### 6. Interface
- The `Discount` interface defines a method `applyDiscount()`, which is implemented by the `Product` class to apply discounts based on product type.

## Project Structure

- **ShoppingCart Package**: Contains all classes related to the shopping cart functionality.
  - `Product` (abstract class)
  - `Electronics` (subclass)
  - `Clothing` (subclass)
  - `User` (class for user management)
  - `Cart` (class for managing products in the cart)
  - `Order` (class for handling order placement)
  - `Payment` (abstract class for payment methods)
  - `CreditCardPayment` and `PayPalPayment` (subclasses for payment processing)

## How to Run the Project

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/OnlineShoppingSystem.git
   cd OnlineShoppingSystem
   ```

2. **Compile the Java Files**:
   Ensure you have Java Development Kit (JDK) installed. Compile the Java files using:
   ```bash
   javac ShoppingCart/*.java
   ```

3. **Run the Application**:
   Execute the main class:
   ```bash
   java ShoppingCart.ShoppingCart
   ```

4. **Follow the On-Screen Instructions**: Interact with the application through the console to add products, view your cart, and place orders.

## Conclusion

This project serves as a practical application of object-oriented programming concepts in Java. It provides a comprehensive understanding of how to design and implement a simple online shopping system, showcasing the power of OOP principles in software development.
