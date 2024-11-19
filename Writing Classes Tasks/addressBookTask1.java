public class addressBookTask1 {
    public static void main(String[] args) {

        Person p1 = new Person("Eda", "eda@gmail.com", "123-456-7890", 23);
        p1.print();
        Person p2 = new Person("Hannah", "hannah@gmail.com", "404-899-9955", 25);
        System.out.println("\nPerson 2 Phone Number: " + p2.getPhoneNumber());
        Person p3 = new Person("Kamen", "kamen@gmail.com", "2414198203", 17);
        System.out.println("\nPerson 3 Email:" + p3.getEmail());
        Person p4 = new Person("Bogdan", "bogdan@gmail.com", "1421414124", 56);
        System.out.println("\nAge of person 4: " + p4.getAge());
        p2.update("hannahmontanta@acs.bg");
        System.out.println("\nPerson 2 New Email: " + p2.getEmail());
    }
}

// Define the Person class here
class Person {
    // Instance variables
    private String name;
    private String email;
    private String phoneNumber;
    private int age;


    // Constructor: Initialize Person data
    public Person(String initName, String initEmail, String initPhone, int initAge) {
        name = initName;
        email = initEmail;
        phoneNumber = initPhone;
        age = initAge;
    }

    public void print() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void update(String newEmail) {
        email = newEmail;
    }

}
