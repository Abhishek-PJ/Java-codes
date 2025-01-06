import java.util.Scanner;

public class BankAccount {

    private String accountHolderName;
    private double balance;

    // Constructor Overloading

    // Default Constructor
    public BankAccount() {
        this.accountHolderName = "Unknown";
        this.balance = 0.0;
    }

    // Parameterized Constructor
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method Overloading

    // Deposit with fixed amount
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Deposit with a message
    public void deposit(double amount, String message) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposited: " + amount + " (" + message + ")");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Credit method to withdraw amount
    public void credit(double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Credited: " + amount);
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance to credit: " + amount);
        } else {
            System.out.println("Invalid credit amount.");
        }
    }

    // Credit method with a message
    public void credit(double amount, String message) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Credited: " + amount + " (" + message + ")");
        } else if (amount > this.balance) {
            System.out.println("Insufficient balance to credit: " + amount);
        } else {
            System.out.println("Invalid credit amount.");
        }
    }

    // Instance Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + this.accountHolderName);
        System.out.println("Balance: " + this.balance);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for account details
        System.out.println("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();

        // Creating an account using user inputs
        BankAccount userAccount = new BankAccount(name, initialBalance);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Display Account Details");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Deposit Amount with Message");
            System.out.println("4. Credit Amount");
            System.out.println("5. Credit Amount with Message");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    userAccount.displayAccountDetails();
                    break;
                case 2:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter message:");
                    String depositMessage = scanner.nextLine();
                    userAccount.deposit(depositAmount, depositMessage);
                    break;
                case 4:
                    System.out.println("Enter amount to credit:");
                    double creditAmount = scanner.nextDouble();
                    userAccount.credit(creditAmount);
                    break;
                case 5:
                    System.out.println("Enter amount to credit:");
                    creditAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter message:");
                    String creditMessage = scanner.nextLine();
                    userAccount.credit(creditAmount, creditMessage);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
