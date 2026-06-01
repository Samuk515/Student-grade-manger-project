import java.io.*;
import java.util.*;

public class FileHandler {
    private static final String FILE_PATH = "data/students.txt";

    public static void saveStudent(Student student) {
        try (FileWriter fw = new FileWriter(FILE_PATH, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(student.getName() + "," + student.getAverage() + "," + student.getGrade());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    public static List<String> loadStudents() {
        List<String> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            System.out.println("No saved data found.");
        }
        return records;
    }
}