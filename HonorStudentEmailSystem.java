public class HonorStudentEmailSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Kamen", "Nikolov", 11, 3.93);
        Student s2 = new Student("Bogdan", "Nakov", 11, 3.23);

        s1.isHonorRollStudent();
        s2.isHonorRollStudent();
    }
}

    class Student {
        private String name;
        private String lastName;
        private int gradeLevel;
        private double gpa;
        private static String schoolName = "ACS";

        public Student(String name, String lastName, int gradeLevel, double gpa) {
            this.name = name;
            this.lastName = lastName;
            this.gradeLevel = gradeLevel;
            this.gpa = gpa;
        }

        boolean isHonorRollStudent() {

            if(gpa >= 3.8){
                HonorStudentEmail();
                return true;
            }
            return false;
        }

        void HonorStudentEmail() {
            System.out.println("Dear " + name +" "+ lastName + ", you are selected as one of the honor students of " + schoolName + " in class 2024 with the GPA of " + gpa + ". Congratulations and we look forward to celebrating your achievement in the graduation ceremony.");
        }
    }
