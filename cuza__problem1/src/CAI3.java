import java.util.Scanner; // Importing scanner method
import java.security.SecureRandom; // Importing Secure Random method
public class CAI3{
public static void main(String[] args) {	// Main method
		quiz();	// Calls quiz method	
}
public static void quiz() {
	SecureRandom randNum = new SecureRandom();	// New Secure Random object
	int numofCorrect = 0;				// Variable for correct answers
	for(int i=0; i<10; i++) {			// Loops to produce 10 questions
	int num1 = randNum.nextInt(10);		 
	int num2 = randNum.nextInt(10);		
	int ans = num1 * num2;				// Multiplies num1 and num2
	askQuestion(num1, num2);			// Prompts Question
	int studAns = readResponse();		// Takes student's answer
	int type1 = 1+randNum.nextInt(4);		// Random number generator for type of response
	int type2 = 1+randNum.nextInt(4);
	if(isAnswerCorrect(ans, studAns)==true){	// Checks if answer is correct
		displayCorrectResponse(type1);
		numofCorrect ++;					// Counts correct answer
	}
	else
		displayIncorrectResponse(type2);
	}
	displayCompletionMessage(numofCorrect);		// Prompts ending message
}
public static void askQuestion(int num1, int num2) {				// Prompts Question
	System.out.println("How much is "+num1+" times "+num2+"?");
}
public static int readResponse() {					// Reads student's answer
	Scanner input = new Scanner(System.in);
	int userAns = input.nextInt();
	return userAns;
}
public static boolean isAnswerCorrect(int actualAns, int studAns) { // Checks if answer is correct
	if(actualAns == studAns)
		return true;
	else
		return false;
}
public static void displayCorrectResponse(int type){		// Displays message when answer is correct
	if(type==1)
		System.out.println("Very good!");
	if(type==2)
		System.out.println("Excellent!");
	if(type==3)
		System.out.println("Nice Work!");
	if(type==4)
		System.out.println("Keep up the good work!");
}
public static void displayIncorrectResponse(int type){		// Displays message when answer is incorrect
	if(type==1)
		System.out.println("No. Please try again.");
	if(type==2)
		System.out.println("Wrong. Try once more.");
	if(type==3)
		System.out.println("Don't give up!");
	if(type==4)
		System.out.println("No. Keep trying.");
}
public static void displayCompletionMessage(int numofCorrect){		// Prompts completion message after quiz is complete
	int grade = numofCorrect*10;			// Calculates grade
	System.out.println("Your quiz score is "+numofCorrect+"!");
	if(grade >= 75)		//Determines if student passed the quiz
		System.out.println("Congratulations, you are ready to go to the next level!");
	else
		System.out.println("Please ask your teacher for extra help.");
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	while(choice != 1 && choice !=2) {
	System.out.println("Would you like to try again? Press 1 for Yes, Press 2 for No."); // Prompts user if they'd like to take the quiz again
	if(choice == 1)
		quiz();
	else if(choice == 2)
		System.exit(0);
	else
		System.out.println("Incorrect Input! Try Again!");
	}
	input.close();
}
}
