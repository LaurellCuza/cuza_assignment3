// This program calculates the monthly interest rate and adds it the savings balance
public class SavingsAccount {
private static double annualInterestRate;	// Private static interest rate variable
private double savingsBalance;				// Private savings Balance variable
public SavingsAccount(double savingsBal) {		// Gets saving balance value from test program
	this.savingsBalance = savingsBal;			// Saves value to private variable
}
public static void modifyInterestRate(double InterestRate) {	// Sets interest rate
	SavingsAccount.annualInterestRate = InterestRate;
}
public double calculateMonthlyInterest() {		// Calculates monthly interest and adds it to savings balance
	double monthlyInterest = (savingsBalance * annualInterestRate)/12;	// Finds monthly interest
	this.savingsBalance = savingsBalance + monthlyInterest;	//Adds monthly interest to savings balance
	return this.savingsBalance;	// Returns value for savings balance
}

}
