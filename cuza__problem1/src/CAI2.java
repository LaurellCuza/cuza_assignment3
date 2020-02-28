import java.util.Scanner;	// Importing scanner method
import java.security.SecureRandom;	// Importing Secure Random method
public class CAI2{
public static void main(String[] args) {	// Main method
		quiz();	// Calls quiz method
	}
public static void quiz() {
	SecureRandom randNum = new SecureRandom();	// New Secure Random object
	int num1 = randNum.nextInt(10);	// Gets random number from 0-9
	int num2 = randNum.nextInt(10);	// Gets random number from 0-9
	int ans = num1 * num2;			// Finds product of num1 and num2
	askQuestion(num1, num2);		// Prompts question
	int studAns = readResponse();	// Gets students answer
	while(isAnswerCorrect(ans, studAns)==false){	// Loops until student gets answer right
		int type1 = 1+randNum.nextInt(4);			// Decides which prompt to print
		displayIncorrectResponse(type1);			
		askQuestion(num1, num2);					// Asks Question
		studAns = readResponse();					// Gets students answer
	}
	int type2 = 1+randNum.nextInt(4);				// Decides which prompt to print
	displayCorrectResponse(type2);
}
public static void askQuestion(int num1, int num2) {		// Asks the question
	System.out.println("How much is "+num1+" times "+num2+"?");
}
public static int readResponse() {				// Reads students answer
	Scanner input = new Scanner(System.in);
	int userAns = input.nextInt();
	return userAns;
}
public static boolean isAnswerCorrect(int actualAns, int studAns) {		// Determines if students answer is correct
	if(actualAns == studAns)
		return true;
	else
		return false;
}
public static void displayCorrectResponse(int type){ //Displays correct prompt
	if(type==1)
		System.out.println("Very good!"); // Option 1
	if(type==2)
		System.out.println("Excellent!"); // Option 2
	if(type==3)
		System.out.println("Nice Work!"); // Option 3
	if(type==4)
		System.out.println("Keep up the good work!"); // Option 4
}
public static void displayIncorrectResponse(int type) { //Displays correct prompt
	if(type==1)
		System.out.println("No. Please try again."); // Option 1
	if(type==2)
		System.out.println("Wrong. Try once more."); // Option 2
	if(type==3)
		System.out.println("Don't give up!"); // Option 3
	if(type==4)
		System.out.println("No. Keep trying."); // Option 4
}
}
