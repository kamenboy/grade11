public class compositionTask {
    public static void main(String[] args) {
        Engine engine = new Engine("V8");
        Car car1 = new Car("Ford", engine, 18);
        car1.displayInfo();

    }
}

class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

class Wheel {
    private int size;

    public Wheel(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class Car {
    private String brand;
    private Engine engine;
    private Wheel frontLeftWheel;
    private Wheel frontRightWheel;
    private Wheel rearRightWheel;
    private Wheel rearLeftWheel;

    public Car(String brand, Engine engine, int wheelSize) {
        this.brand = brand;
        this.engine = engine;
        this.frontLeftWheel = new Wheel(wheelSize);
        this.frontRightWheel = new Wheel(wheelSize);
        this.rearLeftWheel = new Wheel(wheelSize);
        this.rearRightWheel = new Wheel(wheelSize);
    }

    public void displayInfo() {
        System.out.println("Car Brand: " + brand);
        System.out.println("Engine Type: " + engine.getType());
        System.out.println("Front Left Wheel Size: " + frontLeftWheel.getSize() + " in.");
        System.out.println("Front Right Wheel Size: " + frontRightWheel.getSize() + " in.");
        System.out.println("Rear Left Wheel Size: " + rearLeftWheel.getSize() + " in.");
        System.out.println("Rear Right Wheel Size: " + rearRightWheel.getSize() + " in.");
    }

    public String getBrand() {
        return brand;
    }
}
