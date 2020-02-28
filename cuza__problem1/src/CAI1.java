import java.util.Scanner;	// Importing scanner method
import java.security.SecureRandom;	// Importing Secure Random method
public class CAI1 {
public static void main(String[] args) {	// Main method
		quiz();	// Calls quiz method
}
public static void quiz() {
	SecureRandom randNum = new SecureRandom();  // New Secure Random object
	int num1 = randNum.nextInt(10);				// Gets random number from 0-9
	int num2 = randNum.nextInt(10);				// Gets random number from 0-9
	int ans = num1 * num2;						// Finds product of num1 and num2
	askQuestion(num1, num2);					// Prompts question
	int studAns = readResponse();				// Gets students answer
	while(isAnswerCorrect(ans, studAns)==false){	// Determines if answer is correct
		displayIncorrectResponse();					// Loops until student gets answer right
		askQuestion(num1, num2);
		studAns = readResponse();
	}
	displayCorrectResponse();					// Displays correct response when student gets it right
}
public static void askQuestion(int num1, int num2) {  // Prompts question
	System.out.println("How much is "+num1+" times "+num2+"?");
}
public static int readResponse() {			// Gets students answer
	Scanner input = new Scanner(System.in);
	int userAns = input.nextInt();
	return userAns;
}
public static boolean isAnswerCorrect(int actualAns, int studAns) {	// Determines if students answer is correct
	if(actualAns == studAns)
		return true;
	else
		return false;
}
public static void displayCorrectResponse(){		// Prompts correct statement
	System.out.println("Very good!");
}
public static void displayIncorrectResponse() {		// Prompts incorrect statement
	System.out.println("No. Please try again.");
}
}
