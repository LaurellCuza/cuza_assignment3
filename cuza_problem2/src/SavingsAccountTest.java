// This program test the SavingsAccount class
public class SavingsAccountTest {							//Testing class
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000); //Creating new object saver 1
		SavingsAccount saver2 = new SavingsAccount(3000); //Creating new object saver 2
		SavingsAccount.modifyInterestRate(0.04);		//Sets annual interest rate to 4%
		System.out.println("     Monthly Breakdown at 4%   ");      // Table title
		System.out.println(" Month ||  Saver 1  ||  Saver 2");		// Table variables
		System.out.println("------------------------------------"); //	Border
		System.out.println("------------------------------------"); //	Border
		// Prints out saver 1 and saver 2's savings balance for each month at 4% rate
		for(int i=0; i<12; i++) {
			System.out.printf(("\n   %d   ||  %.2f   ||   %.2f  "),(i+1), saver1.calculateMonthlyInterest(),saver2.calculateMonthlyInterest());
			System.out.println("\n------------------------------------");
		}
		System.out.println();   // Spacing
		System.out.println();	// Spacing
		SavingsAccount.modifyInterestRate(0.05);	//Sets annual interest rate to 5%
		System.out.println("     Monthly Breakdown at 5%   ");	// Table title
		System.out.println("Month  ||  Saver 1  ||  Saver 2");	// Table variables
		System.out.println("------------------------------------");	//	Border
		System.out.println("------------------------------------");	//	Border
		// Prints out saver 1 and saver 2's savings balance for each month at 4% rate
		for(int i=0; i<12; i++) {
			System.out.printf(("\n   %d   ||  %.2f   ||   %.2f  "),(i+1), saver1.calculateMonthlyInterest(),saver2.calculateMonthlyInterest());
			System.out.println("\n------------------------------------");
		}
	}
}
