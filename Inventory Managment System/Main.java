import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JTextArea displayArea;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Inventory inventory = new Inventory(3);


        JFrame frame = new JFrame();
        frame.setTitle("Inventory Management System");
        frame.setSize(1000, 700);
        frame.setLayout(null);

        JTextField text1 = new JTextField("Product Variables", 3);
        text1.setBounds(400, 10, 200, 30);
        text1.setEditable(false);
        text1.setHorizontalAlignment(JTextField.CENTER);
        frame.add(text1);

        // txt fields for product details (name, price, quantity)
        JTextField nameFieldText = new JTextField("Product Name:");
        nameFieldText.setBounds(150, 65, 200, 30);
        nameFieldText.setHorizontalAlignment(JTextField.CENTER);
        nameFieldText.setEditable(false);
        frame.add(nameFieldText);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);
        frame.add(nameField);

        JTextField priceFieldText = new JTextField("Product Price:");
        priceFieldText.setBounds(400, 65, 200, 30);
        priceFieldText.setHorizontalAlignment(JTextField.CENTER);
        priceFieldText.setEditable(false);
        frame.add(priceFieldText);

        JTextField priceField = new JTextField();
        priceField.setBounds(400, 100, 200, 30);
        frame.add(priceField);

        JTextField qtyFieldText = new JTextField("Product Quantity:");
        qtyFieldText.setBounds(650, 65, 200, 30);
        qtyFieldText.setHorizontalAlignment(JTextField.CENTER);
        qtyFieldText.setEditable(false);
        frame.add(qtyFieldText);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(650, 100, 200, 30);
        frame.add(quantityField);

        JButton addProductButton = new JButton("Add Product");
        addProductButton.setBounds(150, 150, 200, 50);
        frame.add(addProductButton);

        JButton updateProductButton = new JButton("Update Product");
        updateProductButton.setBounds(400, 150, 200, 50);
        frame.add(updateProductButton);

        JButton displayProductsButton = new JButton("Display Products");
        displayProductsButton.setBounds(650, 150, 200, 50);
        frame.add(displayProductsButton);

        // display area
        displayArea = new JTextArea();
        displayArea.setBounds(150, 250, 700, 400);
        displayArea.setEditable(false);
        frame.add(displayArea);

        //action listeners for buttons
        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Inventory.forbid) {
                    displayArea.setText(" ");
                    JOptionPane.showMessageDialog(null, "You can't add product. Inventory is full.");
                    System.out.println(Inventory.forbid);
                } else {
                    String name = nameField.getText();
                    double price = Double.parseDouble(priceField.getText());
                    int quantity = Integer.parseInt(quantityField.getText());
                    inventory.addProduct(name, price, quantity);
                    displayArea.setText("Product added: " + name + " - Price: " + price + " - Quantity: " + quantity);
                    nameField.setText("");
                    priceField.setText("");
                    quantityField.setText("");
                    System.out.println(Inventory.forbid);
                }
            }
        });

        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                double newPrice = Double.parseDouble(priceField.getText());
                int newQuantity = Integer.parseInt(quantityField.getText());
                inventory.updateProduct(name, newPrice, newQuantity);
                displayArea.setText("Product updated: " + name + " - New Price: " + newPrice + " - New Quantity: " + newQuantity);
                nameField.setText("");
                priceField.setText("");
                quantityField.setText("");
            }
        });

        displayProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(inventory.displayProducts());
            }
        });

        frame.setVisible(true);
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

    public String displayDetails() {
        return "Product Name: " + name + "\nPrice: " + price + "\nQuantity: " + quantity;
    }
}

class Inventory {
    private Product[] products;
    private int productCount;
    public static boolean forbid;

    public Inventory(int capacity) {
        products = new Product[capacity];
        productCount = 0;
        forbid = capacity == 0;
    }

    public void addProduct(String name, double price, int quantity) {
        if (productCount < products.length) {
            products[productCount] = new Product(name, price, quantity);
            productCount++;
            forbid = productCount >= products.length;
        } else {
            forbid = true; // when inventory is full
        }
    }

    public void updateProduct(String name, double newPrice, int newQuantity) {
        boolean updated = false;
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setPrice(newPrice);
                products[i].setQuantity(newQuantity);
                updated = true;
                break;
            }
        }
        if (!updated) {
            System.out.println("Product not found.");
        }
    }

    public String displayProducts() {
        if (productCount == 0) {
            return "No products in inventory.";
        }
        String result = "";
        for (int i = 0; i < productCount; i++) {
            result += products[i].displayDetails() + "\n----------------------------\n";
        }
        return result;
    }
}
