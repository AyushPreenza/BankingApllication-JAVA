import java.util.Scanner;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0 ){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction) );
        }
        else{
            System.out.println("No Transaction Occured");
        }
    }

    void calculateInterest(int years){
        double interestRate = 1.56;
        double newBalance = balance * interestRate * years;
        System.out.println("Your Calculated Interest is: " + newBalance);
    }

    void showMenu(){
        int option = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome, "+ customerName);
        System.out.println(" Your CustomerID is: "+ customerID );
        System.out.println(" ");
        System.out.println("What would you like to do ?");
        System.out.println(" ");
        System.out.println("1. Check your balance");
        System.out.println("2. Make a Deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. View Previous Transaction");
        System.out.println("5. Calculate Interest");
        System.out.println("6. Exit");

        do {
            System.out.println();
            System.out.println("Enter an Option: ");
            option = scanner.nextInt();
            System.out.println();

            switch (option){
                case 1:
                    System.out.println("Balance: $" +balance );
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter an amount to deposit");
                    int amount1 = scanner.nextInt();
                    deposit(amount1);
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter am amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;

                case 4:
                    getPreviousTransaction();
                    break;

                case 5:
                    System.out.println("Enter years: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 6:
                    System.out.println("Successfully Logged out");
                    break;

                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
        while (option != 6);{
            System.out.println("Thank you for banking with us");
        }

    }



}
