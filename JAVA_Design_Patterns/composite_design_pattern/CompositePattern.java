package composite_design_pattern;

import java.util.ArrayList;
import java.util.List;

// Abstract class Account is the base class for all account types
abstract class Account {
  public abstract float getBalance();
}

// DepositeAccount class extends Account, representing a deposit account
class DepositeAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// SavingAccount class extends Account, representing a savings account
class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

// CompositeAccount class extends Account and acts as a composite of multiple accounts
class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account acc : accountList) {
      totalBalance = totalBalance + acc.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.remove(acc);
  }
}

public class CompositePattern {
  public static void main(String[] args) {
    CompositeAccount composite = new CompositeAccount();

    // Add various accounts to the composite account
    composite.addAccount(new DepositeAccount("DA001", 100));
    composite.addAccount(new DepositeAccount("DA002", 150));
    composite.addAccount(new SavingAccount("SA001", 200));

    // Get the total balance of all accounts within the composite
    float totalBalance = composite.getBalance();
    System.out.println("Total Balance: " + totalBalance);
  }
}
