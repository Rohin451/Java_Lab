import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String regNo;
    private String name;
    private String email;
    private String phone;
    private String stdClass;
    private String department;
    
    public Student(String regNo, String name, String email, String phone, String stdClass, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.stdClass = stdClass;
        this.department = department;
    }
    public String toString() {
        return "Reg. No.: " + regNo + "\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone +
                "\nClass: " + stdClass + "\nDepartment: " + department;
    }
    public String toCsvString() {
        return regNo + "," + name + "," + email + "," + phone + "," + stdClass + "," + department + "\n";
    }
    public String getName() {
        return name;
    }
    public String getRegNo() {
        return regNo;
    }
    public void update(String regNo, String name, String email, String phone, String stdClass, String department) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.stdClass = stdClass;
        this.department = department;
    }
}
class StudentManager {
    private ArrayList<Student> students;
    private final int maxStudents;

    public StudentManager(int maxStudents) {
        students = new ArrayList<>();
        this.maxStudents=maxStudents;
    }
    public void addStudent() throws IOException {
        if (students.size() >= maxStudents) {
            System.out.println("Maximum students reached!");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the registration number: ");
        String regNo = scanner.nextLine();
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter the class: ");
        String stdClass = scanner.nextLine();
        System.out.print("Enter the department: ");
        String department = scanner.nextLine();
        Student student = new Student(regNo, name, email, phone, stdClass, department);
        students.add(student);
        String fileName = name + ".csv";
        FileWriter writer = new FileWriter(fileName);
        writer.write(student.toCsvString());
        writer.close();
        System.out.println("Student added successfully!");
    }
    public void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name or registration number of the student: ");
        String searchTerm = scanner.nextLine();
        for (Student student : students) {
            if (student.getName().equals(searchTerm) || student.getRegNo().equals(searchTerm)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public void updateStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name or registration number of the student to update: ");
        String searchTerm = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals(searchTerm) || student.getRegNo().equals(searchTerm)) {
                System.out.print("Enter the new registration number: ");
                String regNo = scanner.nextLine();
                System.out.print("Enter the new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter the new email: ");
                String email = scanner.nextLine();
                System.out.print("Enter the new phone number: ");
                String phone = scanner.nextLine();
                System.out.print("Enter the new class: ");
                String stdClass = scanner.nextLine();
                System.out.print("Enter the new department: ");
                String department = scanner.nextLine();
                Student newStudent = new Student(regNo, name, email, phone, stdClass, department);
                students.set(i, newStudent);
                String fileName = name + ".csv";
                FileWriter writer = new FileWriter(fileName);        
                writer.write(newStudent.toCsvString());
                writer.close();
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
    public class lab6{
    public static void main(String[] args) throws IOException{
        StudentManager studentManager = new StudentManager(100);
        Scanner scanner = new Scanner(System.in);
        int choice;
    
        do {
            System.out.println("1. Add a student");
            System.out.println("2. Search for a student");
            System.out.println("3. Update the details of a student");
            System.out.println("4. Display all students");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
    
            switch (choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:
                    studentManager.searchStudent();
                    break;
                case 3:
                    studentManager.updateStudent();
                    break;
                case 4:
                    studentManager.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice!=5);
    }
}


