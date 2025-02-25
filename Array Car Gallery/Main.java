import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Car[] cars = {
                new Car("BMW", "X5", 2012, 25000, false),
                new Car("Mercedes", "E63s", 2018, 150000, false),
                new Car("Audi", "RS7", 2022, 200000, false),
                new Car("Toyota", "Prius", 2025, 50000, false)
        };
        System.out.println("List of our cars: ");
        displayAllCars(cars);

        System.out.println("\nMost Expensive Car");
        Car expensiveCar = getMostExpensive(cars);
        if (expensiveCar != null) {
            expensiveCar.display();
        }

        System.out.println("\n\nAverage car price: " + getAveragePrice(cars));

        System.out.println("\nWhich car do you want to lease [number]: ");
        int carNum = scan.nextInt();
        System.out.println("Leasing car number " + carNum + "... ");
        cars[carNum-1].setLease(true);
        System.out.println(cars[carNum-1].make() + " " + cars[carNum-1].model() + " is now yours. ");

    }
    public static void displayAllCars(Car[] cars) {
    for (int i = 0; i < cars.length; i++) {
        cars[i].display();
        System.out.println();
    }
}

    public static Car getMostExpensive(Car[] cars) {
        double highestPrice = cars[0].price();
        int highestPriceIndex = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].price() > highestPrice) {
                highestPrice = cars[i].price();
                highestPriceIndex = i;
            }
        }
        return cars[highestPriceIndex];
    }

    public static double getAveragePrice(Car[] cars) {
        double sum = 0;
        for(int i = 0; i< cars.length; i++){
            sum+= cars[i].price();
        }
        return sum/cars.length;
    }
}
    class Car {
        private String make;
        private String model;
        private int year;
        private double price;
        private boolean isLeased;

        public Car(String make, String model, int year, double price, boolean isLeased) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.price = price;
            this.isLeased = isLeased;
        }

        public String make() {
            return make;
        }

        public String model() {
            return model;
        }

        public int year() {
            return year;
        }

        public double price() {
            return price;
        }

        public boolean isLeased() {
            return isLeased;
        }

        public void setLease(Boolean newLease){
        isLeased = newLease;
        }

        public void display() {
            System.out.print("Make: " + make + " | Model: " + model + " | Year: " + year +  " | Price: " + price + " | Leased: ");
            if (isLeased) {
                System.out.print("Yes");
            } else {
                System.out.print("No");
            }

        }
    }
