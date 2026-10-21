public class SavingsAccount extends BankAccount {
  private final String ownerName;

  public SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getOwnerName() {
    return ownerName;
  }
}
