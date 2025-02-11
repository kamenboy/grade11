
import java.util.Scanner;

public class gradebook {
    public static void main(String[] args) {
        String[] students = {"Nikoleta", "Vasil", "Martin", "Svetoslav", "Irina", "Aleksandar"};
        int[] grades = {99, 49, 89, 45, 35, 78};
        System.out.println(calculateAverage(grades));
        System.out.println(findHighestGradeStudent(students, grades));
        System.out.println(findLowestGradeStudent(students, grades));
        System.out.println(countFailedStudents(grades));
        System.out.println(lookupStudentGrade(students, grades, "Martin"));
    }

    private static double calculateAverage(int[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum / grades.length;
    }

    private static String findHighestGradeStudent(String[] studentNames, int[] grades) {
        int highestGrade = grades[0];
        String highestGradeStudent = studentNames[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > highestGrade) {
                highestGrade = grades[i];
                highestGradeStudent = studentNames[i];
            }
        }
        return highestGradeStudent;
    }

    private static String findLowestGradeStudent(String[] studentNames, int[] grades) {
        int lowestGrade = grades[0];
        String lowestGradeStudent = studentNames[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < lowestGrade) {
                lowestGrade = grades[i];
                lowestGradeStudent = studentNames[i];
            }
        }
        return lowestGradeStudent;
    }

    private static int countFailedStudents(int[] grades) {
        int failCount = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 50) {
                failCount++;
            }
        }
        return failCount;
    }

    private static int lookupStudentGrade(String[] studentNames, int[] grades, String studentToLookup) {
        int studentGrade = 0;
        for (int i = 0; i < grades.length; i++) {
            if (studentNames[i].equals(studentToLookup)) {
                studentGrade = grades[i];
            }
        }
        return studentGrade;
    }

}
