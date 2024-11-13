import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    public static void main(String[] args) {

        //frame
        JFrame frame = new JFrame("My Calculator");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(3, 1));

        //panel for textboxes
        JPanel textPanel = new JPanel(new FlowLayout());
        JTextField textBox1 = new JTextField(8);
        JTextField textBox2 = new JTextField(8);
        textPanel.add(textBox1);
        textPanel.add(textBox2);


        //panel for buttons
        JPanel buttons = new JPanel(new FlowLayout());
        JButton add = new JButton("+");
        JButton subs = new JButton("-");
        JButton mul = new JButton("*");
        JButton div = new JButton("/");
        buttonStyle(add);
        buttonStyle(subs);
        buttonStyle(mul);
        buttonStyle(div);

        buttons.add(add);
        buttons.add(subs);
        buttons.add(mul);
        buttons.add(div);

        //panel for result

        JPanel results = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Result");
        results.add(label);


        frame.add(textPanel);
        frame.add(buttons);
        frame.add(results);

        frame.setVisible(true);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked('+', textBox1, textBox2, label);
            }
        });

        subs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked('-', textBox1, textBox2, label);
            }
        });

        mul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked('*', textBox1, textBox2, label);
            }
        });
        div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked('/', textBox1, textBox2, label);
            }
        });
    }

    public static void buttonStyle(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 32));
        button.setForeground(Color.BLUE);
    }


    public static void buttonClicked(char operator, JTextField textBox1, JTextField textBox2, JLabel label) {
        double num1 = Double.parseDouble(textBox1.getText()); // parse the value to double.
        double num2 = Double.parseDouble(textBox2.getText()); // parse the value to double.

        switch (operator) {
            case '+':
                label.setText(String.valueOf(num1 + num2));
                break;
            case '-':
                label.setText(String.valueOf(num1 - num2));
                break;
            case '*':
                label.setText(String.valueOf(num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    label.setText(String.valueOf(num1 / num2));
                    break;
                } else {
                    label.setText("Invalid input");
                }
                break;
        }
    }
}
