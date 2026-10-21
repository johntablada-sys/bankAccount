import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
  private BigDecimal balance = BigDecimal.ZERO;
  boolean isFrozen;

  public double deposit(double amount) {
    if (isFrozen) {
      throw new IllegalStateException("Account is FROZEN, unable to transact");
    }
    balance = balance.add(toCents(amount));
    return getBalance();
  }

  public double withdraw(double amount) {
    if (isFrozen) {
      throw new IllegalStateException("Account is FROZEN, unable to transact");
    }
    BigDecimal withdrawal = toCents(amount);
    if (withdrawal.compareTo(balance) > 0) {
      throw new IllegalArgumentException("Withdrawal exceeds account balance");
    }
    balance = balance.subtract(withdrawal);
    return getBalance();
  }

  public double getBalance() {
    return balance.doubleValue();
  }

  private BigDecimal toCents(double amount) {
    if (!Double.isFinite(amount) || amount <= 0) {
      throw new IllegalArgumentException("Amount must be a positive finite number");
    }
    return BigDecimal.valueOf(amount).setScale(2, RoundingMode.CEILING);
  }

  public void freezeAccount() {
    isFrozen = true;
  }

  public void unFreezeAccount() {
    isFrozen = false;
  }

  public boolean isFrozen() {
    return isFrozen;
  }
}
