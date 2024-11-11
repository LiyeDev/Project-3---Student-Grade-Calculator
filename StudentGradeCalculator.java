import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Student class to hold student details and grades
class Student {
    private String name;
    private String studentId;
    private int[] grades; // Array to hold grades

    // Constructor to initialize student attributes
    public Student(String name, String studentId, int[] grades) {
        this.name = name;
        this.studentId = studentId;
        this.grades = grades;
    }

    // Method to calculate the average grade
    public double calculateAverage() {
        double sum = 0;
        for (int grade : grades) {
            sum += grade; // Sum up all grades
        }
        return sum / grades.length; // Return average
    }

    // Method to display individual grades
    public void displayGrades() {
        System.out.print("Grades for " + name + " (ID: " + studentId + "): ");
        for (int grade : grades) {
            System.out.print(grade + " "); // Print each grade
        }
        System.out.println(); // New line for better formatting
    }

    // Method to determine if the student has passed (assumed passing grade is 60)
    public boolean hasPassed() {
        return calculateAverage() >= 60;
    }

    // Getter for the name
    public String getName() {
        return name;
    }
}

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>(); // List to hold multiple students
        String continueInput;

        // Loop to input multiple students
        do {
            // Input student details
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentId = scanner.nextLine();
            System.out.print("Enter number of grades: ");
            int numGrades = scanner.nextInt();
            int[] grades = new int[numGrades];

            // Input grades
            for (int i = 0; i < numGrades; i++) {
                System.out.print("Enter grade " + (i + 1) + ": ");
                grades[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the newline character

            // Create a new Student object and add it to the list
            students.add(new Student(name, studentId, grades));

            // Ask if the user wants to continue entering students
            System.out.print("Do you want to add another student? (yes/no): ");
            continueInput = scanner.nextLine();
            
        } while (continueInput.equalsIgnoreCase("yes"));

        // Calculate and display class average
        double totalAverage = 0;
        for (Student student : students) {
            student.displayGrades(); // Display grades for each student
            totalAverage += student.calculateAverage(); // Accumulate total average
            String status = student.hasPassed() ? "passed" : "failed"; // Check passing status
            System.out.println(student.getName() + " has " + status + ".");
        }

        // Calculate and display the class average
        if (!students.isEmpty()) {
            totalAverage /= students.size(); // Calculate class average
            System.out.printf("Class average grade: %.2f%n", totalAverage);
        } else {
            System.out.println("No students entered.");
        }

        scanner.close(); // Close the scanner
    }
}
