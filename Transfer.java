// Transfer.java
// Represents a fund transfer ATM transaction

public class Transfer extends Transaction {
    private Keypad keypad; // reference to keypad

    // constant corresponding to menu option to cancel
    private final static int CANCELED = 0;

    public Transfer(int userAccountNumber, Screen atmScreen,
            BankDatabase atmBankDatabase, Keypad atmKeypad) {

        // initialize superclass variables
        super(userAccountNumber, atmScreen, atmBankDatabase);

        // initialize references to keypad
        keypad = atmKeypad;
    } // end Withdrawal constructor

    // perform transaction
    public void execute() {
        // get references to bank database and screen
        BankDatabase bankDatabase = getBankDatabase();
        Screen screen = getScreen();

        // get the account number of the recipient
        int recipient = keypad.getInput(
                "\nEnter the account number of the recipient (or 0 to cancel): ",
                "\nPlease enter a valid account number.\n");

        if (recipient == CANCELED) {
            screen.displayMessageLine("\nCanceling transaction...");
            return;
        }
        if (recipient == getAccountNumber()) {
            screen.displayMessageLine("\nCannot transfer to the same account.");
            return;
        }
        if (!bankDatabase.accountExists(recipient)) {
            screen.displayMessageLine("\nRecipient account not found.");
            return;
        }

        double input = keypad.getDoubleInput(
                "\nEnter the amount to be transferred in HKD (or 0 to cancel): ",
                "\nPlease enter a valid amount.\n");

        if (input == CANCELED) {
            screen.displayMessageLine("\nCanceling transaction...");
            return;
        }
        if (input <= 0.0) {
            screen.displayMessageLine("\nPlease enter a valid amount.");
            return;
        }

        double amount = input;
        double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());
        if (amount > availableBalance) {
            screen.displayMessageLine(
                    "\nInsufficient funds in your account." +
                            "\n\nPlease enter a smaller amount.");
            return;
        }

        bankDatabase.transfer(getAccountNumber(), recipient, amount);
        screen.displayMessageLine(
                "\nTransfer successful. Transferred HKD " + amount + " to account " + recipient + ".");
    }

}