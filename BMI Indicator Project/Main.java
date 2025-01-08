import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JTextArea displayArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setTitle("BMI Calculator");
        frame.setSize(1000, 700);
        frame.getContentPane().setBackground(Color.blue);
        frame.setLayout(null);

        JTextField text1 = new JTextField("BMI Calculator", 3);
        text1.setBounds(400, 10, 200, 30);
        text1.setEditable(false);
        text1.setHorizontalAlignment(JTextField.CENTER);
        frame.add(text1);

        JTextField heightFieldText = new JTextField("Enter Height(cm):");
        heightFieldText.setBounds(250, 65, 200, 30);
        heightFieldText.setHorizontalAlignment(JTextField.CENTER);
        heightFieldText.setEditable(false);
        frame.add(heightFieldText);

        JTextField heightField = new JTextField();
        heightField.setBounds(250, 100, 200, 30);
        frame.add(heightField);

        JTextField weightFieldText = new JTextField("Enter weight(kg):");
        weightFieldText.setBounds(550, 65, 200, 30);
        weightFieldText.setHorizontalAlignment(JTextField.CENTER);
        weightFieldText.setEditable(false);
        frame.add(weightFieldText);

        JTextField weightField = new JTextField();
        weightField.setBounds(550, 100, 200, 30);
        frame.add(weightField);

        JButton submitDataButton = new JButton("Submit Data");
        submitDataButton.setBounds(400, 150, 200, 50);
        frame.add(submitDataButton);

        displayArea = new JTextArea();
        displayArea.setBounds(250, 250, 500, 300);
        displayArea.setEditable(false);
        frame.add(displayArea);

        submitDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Input validation
                if (heightField.getText().isEmpty() || weightField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Fields cannot be empty!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                } else if (!isValidNumber(heightField.getText()) || !isValidNumber(weightField.getText())) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    // Use BMICalculator class to process data
                    BMICalculator bmiCalculator = new BMICalculator(height, weight);
                    String result = bmiCalculator.processData();

                    displayArea.setText(result);

                    // Clear fields after processing
                    heightField.setText("");
                    weightField.setText("");
                }
            }
        });

        frame.setVisible(true);
    }

    public static boolean isValidNumber(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false; // for when input is empty or null
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c) && c != '.') {
                return false; // case when invalid character found
            }
        }
        return true; // all characters are valid
    }
}

// Person class
class Person {
    private double height;
    private double weight;

    public Person(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

// BMICalculator class extends Person
class BMICalculator extends Person {
    public BMICalculator(double height, double weight) {
        super(height, weight);
    }

    // Method to calculate BMI
    public double calculateBMI() {
        double height = getHeight();
        double weight = getWeight();
        return weight / (height * height / 10000); // BMI formula
    }

    // Method to process data and return formatted output
    public String processData() {
        double bmi = calculateBMI();
        String status = getStatus(bmi);
        return String.format("---Person added---\nHeight: %.2f cm\nWeight: %.2f kg\nBMI: %.2f\nStatus: %s\n-------------------------",
                getHeight(), getWeight(), bmi, status);  // use %.2f to restrict the double to two decimal places
    }

    // determine BMI category
    private String getStatus(double bmi) {
        if (bmi <= 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
