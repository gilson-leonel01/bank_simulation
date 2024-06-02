public class Account implements IAccount, ITransactions, IAccountOperation {

    private int id = 0;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private double balance;

    public Account(String fullName, String address, String phoneNumber, String email) {
        this.fullName = fullName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = 0.0;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited into the account.");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn from the account.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void transfer(Account destination, double amount) {
        if (balance >= amount) {
            withdraw(amount);
            destination.deposit(amount);
            System.out.println(amount + " transferred to " + destination.getFullName());
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    @Override
    public void printStatement() {
        System.out.println("Account Holder: " + fullName);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Current Balance: " + balance);
    }
}