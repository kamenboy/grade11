import java.io.*;

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Kamen", 24);
        emp1.writeToFile("employees.txt");
        emp1.readFromFile("employees.txt");
    }
}

class Employee implements Serializable{
    private int employeeID;
    private String name;
    private int age;

    public Employee(int employeeId, String name, int age){
        this.employeeID=employeeId;
        this.name=name;
        this.age=age;
    }

    public void writeToFile(String path){
        try(ObjectOutputStream print = new ObjectOutputStream(new FileOutputStream(path))){
            print.writeObject(this);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(String path){
        try(ObjectInputStream read = new ObjectInputStream(new FileInputStream(path))){
            try{
                while(true){
                    Employee emp = (Employee) read.readObject();
                    System.out.println("Id: " + emp.employeeID + " | Name: " + emp.name + " | Age: " + emp.age);
                }
            }
            catch(EOFException e){};
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
