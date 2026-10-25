// ChequeAccount.java

public class ChequeAccount extends Account {
   private double chequeLimit; // default HKD 50,000

   public ChequeAccount(int accountNumber, int pin,
         double availableBalance, double totalBalance) {
      this(accountNumber, pin, availableBalance, totalBalance, 50000.0);
   }

   public ChequeAccount(int accountNumber, int pin,
         double availableBalance, double totalBalance, double limit) {
      super(accountNumber, pin, availableBalance, totalBalance);
      setChequeLimit(limit);
   }

   public double getChequeLimit() {
      return chequeLimit;
   }

   public void setChequeLimit(double limit) {
      if (limit >= 0)
         chequeLimit = limit;
      else
         chequeLimit = 50000.0;
   }
}