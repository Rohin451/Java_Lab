import java.util.Scanner;

public class Lab4{
    // Global variables
    static int accountNumber;
    static String accountHolderName;
    static double accountBalance;
    static double[] transactions = new double[100];
    static int transactionCount = 0;

    // Function to initialize the customer
    public static void initializeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        accountNumber = scanner.nextInt();
        System.out.print("Enter account holder name: ");
        accountHolderName = scanner.next();
        System.out.print("Enter account balance: ");
        accountBalance = scanner.nextDouble();
        System.out.println("Customer initialized successfully!");
    }

    // Function to deposit money
    public static void depositMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        accountBalance += amount;
        transactions[transactionCount++] = amount;
        System.out.println("Deposit successful!");
    }

    // Function to withdraw money
    public static void withdrawMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > accountBalance) {
            System.out.println("Insufficient balance!");
            return;
        }
        accountBalance -= amount;
        transactions[transactionCount++] = -amount;
        System.out.println("Withdrawal successful!");
    }

    // Function to print the transactions
    public static void printTransactions() {
        System.out.println("Transaction history:");
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i] > 0) {
                System.out.println("Deposit: " + transactions[i]);
            } else {
                System.out.println("Withdrawal: " + (-transactions[i]));
            }
        }
    }

    // Function to print account summary
    public static void printAccountSummary() {
        System.out.println("Account summary:");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder name: " + accountHolderName);
        System.out.println("Account balance: " + accountBalance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean isInitialized = false;
        do {
            System.out.println("\nBank Account Menu:");
            System.out.println("1. Initialize customer");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Print transactions");
            System.out.println("5. Print account summary");
            System.out.println("6. Exit");
    
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:
                    initializeCustomer();
                    isInitialized = true;
                    break;
                case 2:
                    if (!isInitialized) {
                        System.out.println("Please initialize customer first!");
                        break;
                    }
                    depositMoney();
                    break;
                case 3:
                    if (!isInitialized) {
                        System.out.println("Please initialize customer first!");
                        break;
                    }
                    withdrawMoney();
                    break;
                case 4:
                    if (!isInitialized) {
                        System.out.println("Please initialize customer first!");
                        break;
                    }
                    printTransactions();
                    break;
                case 5:
                    if (!isInitialized) {
                        System.out.println("Please initialize customer first!");
                        break;
                    }
                    printAccountSummary();
                    break;
                case 6:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }
}
    
