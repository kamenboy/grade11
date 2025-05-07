import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the filename to save your grocery list: ");
        String fileName = scanner.nextLine();

        PrintWriter outStream = new PrintWriter(new FileOutputStream(fileName));
        System.out.println("Enter grocery items one by one (type 'done' to finish):");

        String item;
        while (true) {
            System.out.print("Item: ");
            item = scanner.nextLine();

            if (item.equalsIgnoreCase("done")) {
                break;
            }

            outStream.println(item);
        }

        outStream.close();
        scanner.close();

        System.out.println("Grocery list saved to " + fileName);
    }
}
