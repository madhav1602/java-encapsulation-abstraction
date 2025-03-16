import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public abstract double calculateInterest();

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// Interface
interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 4.0; // Fixed interest rate

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * (INTEREST_RATE / 100);
    }

    @Override
    public void applyForLoan() {
        System.out.println(getHolderName() + " applied for a loan.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest for Current Account
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV123", "John Doe", 50000));
        accounts.add(new CurrentAccount("CUR456", "Alice Smith", 100000));

        // Processing different account types
        for (int i = 0; i < accounts.size(); i++) {
            BankAccount acc = accounts.get(i);
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Interest Earned: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc; // Type Casting into loanable object
                System.out.println("Loan Eligibility: ₹" + loanAcc.calculateLoanEligibility());
                loanAcc.applyForLoan();
            }

            System.out.println("--------------------------");
        }
    }
}
