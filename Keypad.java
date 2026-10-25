
// Keypad.java
// Represents the keypad of the ATM
import java.util.Scanner; // program uses Scanner to obtain user scanner

public class Keypad {
   private Scanner scanner; // reads data from the command line
   private Screen screen; // reference to the ATM's screen

   // no-argument constructor initializes the Scanner
   public Keypad() {
      scanner = new Scanner(System.in);
      screen = new Screen(); // create screen
   } // end no-argument Keypad constructor

   // return an integer value entered by user
   public int getInput(String prompt, String errorMessage) {
      int input = -1; // initialize to invalid value
      while (input < 0) {
         screen.displayMessage(prompt);

         if (!scanner.hasNextInt()) {
            screen.displayMessage(errorMessage);
            scanner.next(); // Discard the current non-integer input
            continue; // Skip the remaining parts of code in the method
         }

         input = scanner.nextInt();
      }
      return input;
   } // end method getInput

   public double getDoubleInput(String message, String errorMessage) {
      double input = -1.0; // initialize to invalid value
      while (input < 0) {
         screen.displayMessage(message);

         if (!scanner.hasNextDouble()) {
            screen.displayMessage(errorMessage);
            scanner.next(); // Discard the current non-double input
            continue; // Skip the remaining parts of code in the method
         }

         input = scanner.nextDouble();
      }
      return input;
   }
} // end class Keypad

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