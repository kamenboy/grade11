import java.util.Scanner;

public class Main {

    static String[] itemNames = {"Coke", "Chips", "Sweets", "Water"};
    static double[] itemPrices = {1.50, 1.00, 0.75, 1.25};
    static int[] itemQuantities = {5, 5, 5, 5};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayItems();

            System.out.println("Enter the item number to purchase or 0 to exit:");
            int selection = scanner.nextInt();

            if (selection == 0) {
                running = false;
                System.out.println("Exiting the program. Thank you!");
            } else if (selection >= 1 && selection <= itemNames.length) {
                if (itemQuantities[selection - 1] > 0) {
                    System.out.println("You selected: " + itemNames[selection - 1]);
                    System.out.println("Price: $" + itemPrices[selection - 1]);
                    System.out.print("Insert money: $");
                    double insertedMoney = scanner.nextDouble();

                    if (insertedMoney >= itemPrices[selection - 1]) {
                        itemQuantities[selection - 1]--;
                        double change = insertedMoney - itemPrices[selection - 1];
                        System.out.println("Item dispensed: " + itemNames[selection - 1]);
                        System.out.println("Your change: $" + change);
                    } else {
                        System.out.println("Insufficient funds. Please insert more money.");
                    }
                } else {
                    System.out.println("Sorry, that item is out of stock.");
                }
            } else {
                System.out.println("Invalid selection. Please choose a valid item number.");
            }
        }

    }

    public static void displayItems() {
        System.out.println("\nAvailable items:");
        for (int i = 0; i < itemNames.length; i++) {
            System.out.println((i + 1) + ". " + itemNames[i] + " - $" + itemPrices[i] + " (" + itemQuantities[i] + " in stock)");
        }
    }
}
