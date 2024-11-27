public class StudDiscountSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Kamen Nikolov", 20, "11", "Physics", "Full-Time", 10000);
        Student s2 = new Student("Bogdan Nakov", 23, "12", "Philosophy", "Part-Time", 10000);
        s1.isEligibleForDiscount();
        s2.isEligibleForDiscount();
    }
}

class Student {
    private String name;
    private int age;
    private String studentID;
    private String courseName;
    private String courseDuration;
    private double tuitionFee;
    private final String schoolName = "ACS";
    double discountedFee;

    public Student(String name, int age, String studentID, String courseName, String courseDuration, double tuitionFee) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.tuitionFee = tuitionFee;
    }

    boolean isEligibleForDiscount() {
        if (age < 25 && courseDuration.equals("Full-Time")) {
            calculateDiscount();
            generateDiscountEmail();
            return true;
        }
        return false;
    }

    void calculateDiscount() {
        discountedFee = tuitionFee * (1 - 0.15);
    }

    void generateDiscountEmail() {
        System.out.println("Dear " + name + ",\n" +
                "We are pleased to inform you that you are eligible for a 15% discount on your tuition fee for the course " + courseName + ". \n" +
                "Your discounted tuition fee is " + discountedFee + ". We hope this helps in supporting your academic journey!\n" +
                "Best regards,\n" +
                schoolName + " Administration\n");
    }
}
