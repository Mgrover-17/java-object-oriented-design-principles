import java.util.ArrayList;

class Bank{
    private String bankName;
    private ArrayList<Customer>customers; // A bank is associated with multiple customers

    Bank(String bankName){
        this.bankName=bankName;
        this.customers=new ArrayList<>();  //The customers list is initialized as empty as there are no customers when a bank is first created.
    }

    public String getBankName(){ //to access the private name variable and to protect data from unauthorized modification.
        return bankName;
    }

    public void addAccount(Customer customer){  //customer variable representing a Customer object
        customers.add(customer);
    }

    public Account openAccount(Customer customer, int accountNumber, double initialDeposit) {
        Account newAccount = new Account(accountNumber, initialDeposit, this);
        customer.addAccount(newAccount);
        return newAccount;
    }

    // Method to display all customers of the bank
    public void displayCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer cust : customers) {
            System.out.println("- " + cust.getName());
        }
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts;  // A customer can have multiple accounts

    // Constructor
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>(); // Initialize empty list of accounts
    }

    // Getter for customer name
    public String getName() {
        return name;
    }

    // Method to add an account for the customer
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to view all accounts of the customer
    public void viewBalance() {
        System.out.println("Accounts of " + name + ":");
        for (Account acc : accounts) {
            System.out.println("- Account Number: " + acc.getAccountNumber() + ", Balance: $" + acc.getBalance() + " (Bank: " + acc.getBank().getBankName() + ")");
        }
    }
}

class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;  // Association with Bank

    // Constructor
    public Account(int accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

public class BankAndAccount {
    public static void main(String[] args) {
        // Creating a bank
        Bank sbiBank = new Bank("State Bank of India");

        // Creating customers
        Customer ram = new Customer("ram");
        Customer sham = new Customer("sham");

        // Adding customers to the bank
        sbiBank.addAccount(ram);
        sbiBank.addAccount(sham);

        // Opening accounts for customers
        Account account1 = sbiBank.openAccount(ram, 123456, 5000);
        Account account2 = sbiBank.openAccount(ram, 789012, 8000);
        Account account3 = sbiBank.openAccount(sham, 345678, 10000);

        // Display customers of the bank
        sbiBank.displayCustomers();

        // Each customer views their accounts and balance
        ram.viewBalance();
        sham.viewBalance();
    }
}
