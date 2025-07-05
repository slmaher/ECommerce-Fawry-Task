# E-Commerce Java Console App

## Features
- Product management: name, price, quantity, expiration, shipping weight.
- Cart functionality with quantity checks.
- Full checkout process with receipt and shipping details.
- Handles expired products, insufficient balance, and empty carts.

### Option 1: Using the included JDK
```bash
# Navigate to the project directory
cd Fawry_Ecommerce_Submission

# Compile all Java files
Oracle_JDK-24/bin/javac -cp . *.java model/*.java cart/*.java service/*.java user/*.java

# Run the application
Oracle_JDK-24/bin/java -cp . ECommerceApp
```

### Option 2
```bash
# Navigate to the project directory
cd Fawry_Ecommerce_Submission

# Compile all Java files
javac -cp . *.java model/*.java cart/*.java service/*.java user/*.java

# Run the application
java -cp . ECommerceApp

##Notes
All code was written manually and covers the expected use cases with test scenarios in `main()`.
    

    