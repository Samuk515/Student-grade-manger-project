import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Grade Manager ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("How many subjects? ");
                    int subjectCount = scanner.nextInt();
                    double[] marks = new double[subjectCount];

                    for (int i = 0; i < subjectCount; i++) {
                        System.out.print("Mark for subject " + (i + 1) + ": ");
                        marks[i] = scanner.nextDouble();
                    }

                    Student student = new Student(name, marks);
                    double avg = GradeCalculator.calculateAverage(marks);
                    String grade = GradeCalculator.assignGrade(avg);
                    student.setAverage(avg);
                    student.setGrade(grade);

                    FileHandler.saveStudent(student);
                    System.out.println("Saved! " + student);
                    break;

                case 2:
                    List<String> records = FileHandler.loadStudents();
                    if (records.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        System.out.println("\n--- All Students ---");
                        for (String record : records) {
                            String[] parts = record.split(",");
                            System.out.println("Name: " + parts[0] + " | Average: " + parts[1] + " | Grade: " + parts[2]);
                        }
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}