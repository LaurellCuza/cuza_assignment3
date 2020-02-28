import java.util.Scanner;			// Importing Scanner method
import java.security.SecureRandom;	// Importing Secure Random method
public class CAI4{
public static void main(String[] args) {
		quiz();						// Quiz method called
}
public static void quiz() {
	int numofCorrect = 0;				// Initializing counter for number of correct answers
	SecureRandom randNum = new SecureRandom();
	System.out.println("Choose Difficulty level of 1, 2, 3, 4: ");
	int choice = readDifficulty();		// Reads student's difficulty choice
	for(int i=0; i<10; i++) {			// Loops to produce 10 questions
	int num1 = generateQuestionArguement(choice);		// Gets random number
	int num2 = generateQuestionArguement(choice);		// Gets random number
	askQuestion(num1, num2);			// Prompts question
	int ans = num1 * num2;				// Finds correct answer
	int studAns = readResponse();		// Gets students answer
	int type1 = 1+randNum.nextInt(4);
	int type2 = 1+randNum.nextInt(4);
	if(isAnswerCorrect(ans, studAns)==true){	//Checks if student's answer is correct
		displayCorrectResponse(type1);	// Prompts correct response
		numofCorrect ++;		// Counts number of correct answers
	}
	else
		displayIncorrectResponse(type2);	// Prompts correct response
	}
	displayCompletionMessage(numofCorrect);		// Completion message call
}
public static void askQuestion(int num1, int num2) {	// Prompt question method
	System.out.println("How much is "+num1+" times "+num2+"?");
}
public static int readResponse() {		// Reads student's answer
	Scanner input = new Scanner(System.in);
	int userAns = input.nextInt();
	return userAns;
}
public static boolean isAnswerCorrect(int actualAns, int studAns) {		// Checks if students answer is correct
	if(actualAns == studAns)
		return true;
	else
		return false;
}
public static void displayCorrectResponse(int type){	// Prints correct response
	if(type==1)
		System.out.println("Very good!");
	if(type==2)
		System.out.println("Excellent!");
	if(type==3)
		System.out.println("Nice Work!");
	if(type==4)
		System.out.println("Keep up the good work!");
}
public static void displayIncorrectResponse(int type){	// Prints incorrect response
	if(type==1)
		System.out.println("No. Please try again.");
	if(type==2)
		System.out.println("Wrong. Try once more.");
	if(type==3)
		System.out.println("Don't give up!");
	if(type==4)
		System.out.println("No. Keep trying.");
}
public static void displayCompletionMessage(int numofCorrect){		//Displays message after quiz is complete
	int grade = numofCorrect*10;
	System.out.println("Your quiz score is "+numofCorrect+"!");
	if(grade >= 75)		// Checks if student passes the quiz
		System.out.println("Congratulations, you are ready to go to the next level!");
	else
		System.out.println("Please ask your teacher for extra help.");
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	while(choice != 1 && choice !=2) {
	System.out.println("Would you like to try again? Press 1 for Yes, Press 2 for No."); // Asks if student wants to take the quiz again
	if(choice == 1)
		quiz();
	else if(choice == 2)
		System.exit(0);
	else
		System.out.println("Incorrect Input! Try Again!");
	}
	input.close();
}
public static int readDifficulty(){		// Reads difficulty choice
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	return choice;
}
public static int generateQuestionArguement(int choice){	// Generates a random number 
	SecureRandom randNum = new SecureRandom();				// for the difficulty the student entered
	int num;
	if(choice == 1) {
		num = randNum.nextInt(10);
		return num;
	}
	else if(choice == 2) {
		num = randNum.nextInt(100);
		return num;
	}
	else if(choice == 3) {
		num = randNum.nextInt(1000);
		return num;
	}
	else{
		num = randNum.nextInt(10000);
		return num;
	}
}
}
