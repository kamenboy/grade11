import java.util.Scanner;

public class Main {

    static String[] bookNames = {"Harry Potter", "The Alchemist", "Little Prince", "Allice in Wonderland"};
    static double[] bookPrices = {20.50, 14.95, 23.99, 29.99};
    static int[] bookQuantities = {7, 3, 15, 18};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("\nHello! Welcome to Kamen's Bookstore!\n Type 0 at any time to exit!");

        while (running) {
            System.out.println("Are you looking for a specific book? If you aren't, just type NO.\n" +
                    " If you are, please type the name of the book you wish to search for: ");
            String input = scanner.nextLine();

            checkAvailability(input);
            if(input.equalsIgnoreCase("no")) {
            }
            displayInventory();
            System.out.println("Enter the index of the book you want to purchase or 0 to exit:");
            int selection = scanner.nextInt();

            if (selection == 0) {
                running = false;
                System.out.println("Exiting the program. Thank you!");
            } else if (selection >= 1 && selection <= bookNames.length) {
                if (bookQuantities[selection - 1] > 0) {
                    System.out.println("You selected: " + bookNames[selection - 1]);
                    System.out.println("Price: $" + bookPrices[selection - 1]);
                    System.out.print("Insert money: $");
                    double insertedMoney = scanner.nextDouble();

                    if (insertedMoney >= bookPrices[selection - 1]) {
                        bookQuantities[selection - 1]--;
                        double change = insertedMoney - bookPrices[selection - 1];
                        System.out.println("Item dispensed: " + bookNames[selection - 1]);
                        System.out.println("Balance left: $" + change);

                        running = false;
                    } else {
                        System.out.println("Insufficient funds. Please insert more money.");
                        running = false;
                    }
                } else {
                    System.out.println("Sorry, that item is out of stock.");
                    running = false;

                }
            } else {
                System.out.println("Invalid selection. Please choose a valid item number.");
                running = false;
            }
        }

    }
    public static void checkAvailability(String bookName){
        boolean availability = false;
        int availabilityIndex = 0;
        if(bookName.equalsIgnoreCase("no")) {
            System.out.println();
        } else {
            for (int i = 0; i < bookNames.length; i++) {
                if (bookNames[i].equalsIgnoreCase(bookName)) {
                    availability = true;
                    availabilityIndex = i+1;
                }
            }
            if(!availability) {
                System.out.println("Currently, this book is not available :(");
            }else{
                System.out.println("This book is available! The index of the book is " + availabilityIndex);
            }
        }
    }

    public static void displayInventory() {
        System.out.println("\nAvailable books:");
        for (int i = 0; i < bookNames.length; i++) {
            System.out.println((i + 1) + ". " + bookNames[i] + " - $" + bookPrices[i] + " (" + bookQuantities[i] + " in stock)");
        }
    }
}
