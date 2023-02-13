import java.util.Scanner;

public class StudentDetails {
    static String[] studentNames = new String[1024];
    static String[][] studentDetails = new String[1024][5];
    static int studentCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add student details");
            System.out.println("2. Display student details");
            System.out.println("3. Search student details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addDetails();
                    break;
                case 2:
                    displayDetails();
                    break;
                case 3:
                    searchDetails();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    static void addDetails() {//Function to Collect the details of the students
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        int index = searchStudent(name);
        if (index != -1) {
            System.out.println("Details already exists for this student.");
        } else {
            studentNames[studentCount] = name;
            System.out.print("Enter register number: ");
            studentDetails[studentCount][0] = sc.nextLine();
            System.out.print("Enter email: ");
            studentDetails[studentCount][1] = sc.nextLine();
            System.out.print("Enter class: ");
            studentDetails[studentCount][2] = sc.nextLine();
            System.out.print("Enter department: ");
            studentDetails[studentCount][3] = sc.nextLine();
            studentCount++;
            System.out.println("Details added successfully.");
        }
    }

    static void displayDetails() {//Function to display the details of the student
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + studentNames[i]);
            System.out.println("Register number: " + studentDetails[i][0]);
            System.out.println("Email: " + studentDetails[i][1]);
            System.out.println("Class: " + studentDetails[i][2]);
            System.out.println("Department: " + studentDetails[i][3]);
            System.out.println("---");
        }
    }

    static int searchStudent(String name) {// A function to fetch the name of students from the array
        for (int i = 0; i < studentCount; i++) {
            if (studentNames[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }

    static void searchDetails() {//This function takes the name of a student as input from the user and searches for it in the names array.
      //If the name is found, it retrieves the corresponding details from the details array and displays them to the user. 
      //If the name is not found, it prints an error message.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        int index = searchStudent(name);
        if (index != -1) {
            System.out.println("Name: " + studentNames[index]);
            System.out.println("Register number: " + studentDetails[index][0]);
            System.out.println("Email: " + studentDetails[index][1]);
            System.out.println("Class: " + studentDetails[index][2]);
            System.out.println("Department: " + studentDetails[index][3]);
        } else {
            System.out.println("Details not found for this student.");
        }
    }
}

