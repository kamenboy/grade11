class Vehicle {
    String brand;
    int year;
    double distance;
    double time;

    public Vehicle(String brand, int year, double distance, double time) {
        this.brand = brand;
        this.year = year;
        this.distance = distance;
        this.time = time;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    public double calculateSpeed() {
        return distance / time;
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    public Car(String brand, int year, double distance, double time, int numberOfDoors) {
        super(brand, year, distance, time);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }

    @Override
    public double calculateSpeed() {
        return super.calculateSpeed() * 0.95;
    }
}

class Motorcycle extends Vehicle {
    boolean hasHelmetStorage;

    public Motorcycle(String brand, int year, double distance, double time, boolean hasHelmetStorage) {
        super(brand, year, distance, time);
        this.hasHelmetStorage = hasHelmetStorage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        super.displayDetails();
        System.out.println("Helmet Storage: " + (hasHelmetStorage ? "Yes" : "No"));
    }

    @Override
    public double calculateSpeed() {
        return super.calculateSpeed() * 1.1;
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota", 2020, 150, 2, 4);
        Vehicle v2 = new Motorcycle("Yamaha", 2021, 100, 1, true);
        Vehicle v3 = new Car("Honda", 2019, 180, 2.5, 2);

        Vehicle[] vehicles = { v1, v2, v3 };

        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Calculated Speed: " + v.calculateSpeed() + " km/h");
            System.out.println("-----------------------------");
        }
    }
}
