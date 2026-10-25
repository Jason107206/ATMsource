// CashDispenser.java
// Represents the cash dispenser of the ATM

public class CashDispenser {
    // the default initial number of Banknotes in the cash dispenser
    private static final int HKD100_INITIAL_COUNT = 500;
    private static final int HKD500_INITIAL_COUNT = 200;
    private static final int HKD1000_INITIAL_COUNT = 100;
    private int hkd100Count; // number of HKD 100 Banknotes remaining
    private int hkd500Count; // number of HKD 500 Banknotes remaining
    private int hkd1000Count; // number of HKD 1000 Banknotes remaining

    // no-argument CashDispenser constructor initializes count to default
    public CashDispenser() {
        hkd100Count = HKD100_INITIAL_COUNT; // set count of HKD 100 Banknotes attribute to default
        hkd500Count = HKD500_INITIAL_COUNT; // set count of HKD 500 Banknotes attribute to default
        hkd1000Count = HKD1000_INITIAL_COUNT; // set count of HKD 1000 Banknotes attribute to default
    } // end CashDispenser constructor

    public void dispenseCash(int amount) {
        int amountToBeDispensed = amount;

        int hkd1000BanknotesRequired = amountToBeDispensed / 1000;
        hkd1000Count -= hkd1000BanknotesRequired;
        amountToBeDispensed = amountToBeDispensed % 1000;

        int hkd500BanknotesRequired = amountToBeDispensed / 500;
        hkd500Count -= hkd500BanknotesRequired;
        amountToBeDispensed = amountToBeDispensed % 500;

        int hkd100BanknotesRequired = amountToBeDispensed / 100;
        hkd100Count -= hkd100BanknotesRequired;
        amountToBeDispensed = amountToBeDispensed % 100;
    }

    // indicates whether cash dispenser can dispense desired amount
    public boolean isSufficientCashAvailable(int amount) {
        int amountToBeDispensed = amount;

        int hkd1000BanknotesRequired = amountToBeDispensed / 1000;
        if (hkd1000BanknotesRequired > hkd1000Count) {
            return false;
        }
        amountToBeDispensed = amountToBeDispensed % 1000;

        int hkd500BanknotesRequired = amountToBeDispensed / 500;
        if (hkd500BanknotesRequired > hkd500Count) {
            return false;
        }
        amountToBeDispensed = amountToBeDispensed % 500;

        int hkd100BanknotesRequired = amountToBeDispensed / 100;
        if (hkd100BanknotesRequired > hkd100Count) {
            return false;
        }
        amountToBeDispensed = amountToBeDispensed % 100;

        return amountToBeDispensed == 0;
    } // end method isSufficientCashAvailable
} // end class CashDispenser

/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/