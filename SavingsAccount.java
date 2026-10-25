// SavingsAccount.java

public class SavingsAccount extends Account {
   private double interestRate; // default 0.5% per annum

   public SavingsAccount(int accountNumber, int pin,
         double availableBalance, double totalBalance) {
      this(accountNumber, pin, availableBalance, totalBalance, 0.005);
   }

   public SavingsAccount(int accountNumber, int pin,
         double availableBalance, double totalBalance, double rate) {
      super(accountNumber, pin, availableBalance, totalBalance);
      setInterestRate(rate);
   }

   public double getInterestRate() {
      return interestRate;
   }

   public void setInterestRate(double rate) {
      if (rate >= 0)
         interestRate = rate;
      else
         interestRate = 0.005;
   }
}