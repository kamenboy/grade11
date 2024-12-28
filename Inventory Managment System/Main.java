import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

        // set a frame
        imsFrame IMSFrame = new imsFrame();

        // Add a text field (Jtxtfield)
        JTextField text1 = new JTextField( "Product Variables",3);
        text1.setBounds(450, 10, 100, 30);
        IMSFrame.add(text1);

        //Add Buttons
        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(150, 50, 200, 50);
        IMSFrame.add(addProductButton);

        JButton updateProductButton = new JButton("Update Product");
        updateProductButton.setBounds(400, 50, 200, 50);
        IMSFrame.add(updateProductButton);

        JButton displayProductsButton = new JButton("Display Products");
        displayProductsButton.setBounds(650, 50, 200, 50);
        IMSFrame.add(displayProductsButton);
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayDetails() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}

class Inventory {
    private Product[] product;
    private int productCount;

    public Inventory(int capacity) {
        product = new Product[capacity];
        productCount = 0;
    }

    public void addProduct(String name, double price, int quantity) {
        if (productCount < 3) {
            product[productCount] = new Product(name, price, quantity);
            productCount++;
        } else {
            System.out.println("Inventory is full. Cannot add newer products");
        }
    }

    public void updateProduct(String name, double newPrice, int newQuantity) {
        for (int i = 0; i < productCount; i++) {
            if (product[i].getName().equals(name)) {
                product[i].setPrice(newPrice);
                product[i].setQuantity(newQuantity);
                System.out.println("Product updates successfully");
            }
        }
    }

    public void displayProducts() {
        if (productCount == 0) {
            System.out.println("No products in the inventory.");
        } else {
            for (int i = 0; i < productCount; i++) {
                product[i].displayDetails();
                System.out.println("----------------------------");
            }
        }
    }
}
