import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clickerGame {

    public static void main(String[] args) {

       JFrame frame = new JFrame("clicker game");
       JLabel showCLicks = new JLabel("0");
       JButton plusButton = new JButton("+");
       JButton minusButton = new JButton("-");
       JButton resetButton = new JButton("reset");


       frame.setLayout(new GridLayout(4,1));
       frame.setSize(300,300);
       frame.add(showCLicks);
       frame.add(plusButton);
       frame.add(minusButton);
       frame.add(resetButton);

       frame.setVisible(true);

       plusButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter++;
               showCLicks.setText(String.valueOf(counter));
           }
       });
       minusButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               if(counter>0){
                   counter--;
               }else{
                   counter = 0 ;
               }
               showCLicks.setText(String.valueOf(counter));
           }
       });

       resetButton.addActionListener(new ActionListener(){

           public void actionPerformed(ActionEvent e){
               int counter = Integer.parseInt(showCLicks.getText());
               counter = 0;
               showCLicks.setText(String.valueOf(counter));
           }
       });


    }
}
