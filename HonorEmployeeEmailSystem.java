public class HonorEmployeeEmailSystem {
    public static void main(String[] args) {
        Employee s1 = new Employee("Kamen", "Nikolov", "11", 52000, 4.7);
        Employee s2 = new Employee("Bogdan", "Nakov", "23", 40000, 3.2);
        s1.calculateBonus();
        s2.calculateBonus();
        s1.sendPerformanceEmail();
        s2.sendPerformanceEmail();
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String employeeID;
    private double salary;
    private double performanceRating;
    double bonus;

    public Employee(String firstName, String lastName, String employeeID, double salary, double performanceRating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    boolean isHighPerformer() {

        if (performanceRating >= 4.5) {
            return true;

        }
        return false;
    }

    void calculateBonus() {
        if (isHighPerformer()) {
            bonus = this.salary * 0.2;
        } else {
            bonus = this.salary * 0.05;
        }
    }

    void sendPerformanceEmail() {
        System.out.println("Dear " + firstName + " " + lastName + "\n" +
                "Based on your performance rating of " + performanceRating + ", you are a valued member of our team. \n" +
                "Your bonus for this period is " + bonus + ". Keep up the great work!\n");
    }
}
