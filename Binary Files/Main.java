import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        writeEmp("text.txt");
        readEmp("text.txt");

    }

    public static void writeEmp(String path) {
        try (DataOutputStream outStream = new DataOutputStream(new FileOutputStream(path))) {
            String[] namesString = { "Kamen", "Bogdan", "Ivailo", "Yan", "Vasil" };
            for (int i = 0; i < 5; i++) {
                outStream.writeUTF("Student ID: " + (i + 1) + ", Name: " + namesString[i] + ", Grade: "
                        + ((int) (Math.random() * (12 - 8)) + 8) + ", GPA: " + String.format("%.2f", ((Math.random() * (6 - 2)) + 2)));
            }

        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }
    }

    public static void readEmp(String path) {
        try (DataInputStream inStream = new DataInputStream(new FileInputStream(path))) {
            try {
                while (true) {
                    System.out.println(inStream.readUTF());
                }
            } catch (EOFException e) {
                System.out.println("Problem " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Problem: " + e.getMessage());
        }

    }
}
