import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine().toLowerCase();
        String filename = name + "-answers.txt";

        try {
            PrintWriter outStream = new PrintWriter(new FileOutputStream(filename));

            System.out.println("Let's begin your math quiz!");
            for (int i = 1; i <= 5; i++) {
                int num1 = rand.nextInt(100);
                int num2 = rand.nextInt(100);
                char operator = rand.nextBoolean() ? '+' : '-';
                int correctAnswer = operator == '+' ? num1 + num2 : num1 - num2;

                System.out.print("Question " + i + ": " + num1 + " " + operator + " " + num2 + " = ");
                int userAnswer = scanner.nextInt();
                boolean isCorrect = (userAnswer == correctAnswer);
                String result = isCorrect ? "Correct" : "Incorrect";

                outStream.println("Q" + i + ": " + num1 + " " + operator + " " + num2 +
                        " = " + correctAnswer + " | Your Answer: " + userAnswer + " | " + result);
            }

            outStream.close();
            System.out.println("Quiz completed. Your answers are saved in " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}
