import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JTextArea displayArea;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        JFrame frame = new JFrame("BMI Calculator APP");
        frame.setTitle("BMI Calculator");
        frame.setSize(1000, 700);
        frame.getContentPane().setBackground(Color.blue);
        frame.setLayout(null);
        // textbox at the top
        JTextField text1 = new JTextField("BMI Calculator", 3);
        text1.setBounds(400, 10, 200, 30);
        text1.setEditable(false);
        text1.setHorizontalAlignment(JTextField.CENTER);
        frame.add(text1);

        // txt fields for personal details (height, weight)
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

        //button to submit data
        JButton submitDataButton = new JButton("Submit Data");
        submitDataButton.setBounds(400, 150, 200, 50);
        frame.add(submitDataButton);


        // display area
        displayArea = new JTextArea();
        displayArea.setBounds(250, 250, 500, 300);
        displayArea.setEditable(false);
        frame.add(displayArea);

        //action listeners for buttons
        submitDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    double height = Double.parseDouble(heightField.getText());
                    double weight = Double.parseDouble(weightField.getText());
                    double BMI = weight/(height*height/10000);
                    String status = "";
                    if(BMI<=18.5){
                        status = "Underweight";
                    }else if(BMI<25){
                        status = "Normal";
                    }else if(BMI<30){
                        status="Overweight";
                    }else{
                        status = "Obese";
                    }
                    displayArea.setText("---Person added---\nHeight:  " + height + "\nWeight: " + weight + "\nBMI Number: " + BMI + "\nStatus: " + status + "\n-------------------------");
                    heightField.setText("");
                    weightField.setText("");
                }
            }
        );

        frame.setVisible(true);
    }
}
//class of person
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
    public String displayDetails() {
        return "Weight: " + weight + "\nHeight: " + height + "\nBMI Indicator: " + weight/(height*height/10000);
    }
}
