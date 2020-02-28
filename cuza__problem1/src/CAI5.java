import java.util.Scanner;		// Imports Scanner method
import java.security.SecureRandom;	// Imports Secure Random method
public class CAI5{
public static void main(String[] args) {
		quiz();			// Quiz method called
}
public static void quiz() {
	int numofCorrect = 0;		// Correct answer counter initialized to 0
	SecureRandom randNum = new SecureRandom();
	System.out.println("Choose Difficulty level of 1, 2, 3, 4: ");
	int choice = readDifficulty();		// Reads difficulty choice
	System.out.println("Press 1 for Addition, 2 for Subtraction, 3 for Multiplication"
			+ ", 4 for Division, or 5 for Mixed");
	int choice2 = readProblemType();		// Reads students problem type choice
	for(int i=0; i<10; i++) {		// Print outs 10 questions
	int num1 = generateQuestionArguement(choice);	// Generates random number
	int num2 = generateQuestionArguement(choice);	// Generates random number
	int ans = askQuestion(num1,num2,choice2,choice);	// Asks question based on problem type
	int studAns = readResponse();		// Reads student's answer
	int type = 1+randNum.nextInt(4);
	if(isAnswerCorrect(ans, studAns)==true){	// Checks if answer is correct
		displayCorrectResponse(type);	// Prints correct response
		numofCorrect++;	// Counts number of correct answer
	}
	else
		displayIncorrectResponse(type);		// Prints incorrect response
	}
	displayCompletionMessage(numofCorrect);		// Prints completion message
}
public static int askQuestion(int num1, int num2, int choice, int choice2) {	// Generates questions 
	SecureRandom randNum = new SecureRandom();									// based on student's choice
	int ans = 0;
	if(choice == 1) {		// Choice 1: Addition
		System.out.println("What is "+num1+" plus "+num2+"?");
		ans = num1 + num2;
	}
	if(choice == 2) {	// Choice 2: Subtraction
		System.out.println("What is "+num1+" minus "+num2+"?");
		ans = num1 - num2;
	}
	if(choice == 3) {	// Choice 3: Multiplication
		System.out.println("What is "+num1+" times "+num2+"?");
		ans = num1 * num2;
	}
	if(choice == 4) {	// Choice 4: Division
		if(num2 == 0) {
			num2 = 1 + generateQuestionArguement(choice2);	// Makes sure there is no division by 0
		}
		System.out.println("What is "+num1+" divided by "+num2+"? (Round down to nearest whole number)");
		ans = num1/num2;
	}
	if(choice == 5){	// Choice 5: Mixed
		int choice1 = 1 + randNum.nextInt(4);
		ans = askQuestion(num1, num2, choice1, choice2);	// Recursive function to get mixed result
	}
	return ans;
}
public static int readResponse() {		// Reads student's answer
	Scanner input = new Scanner(System.in);
	int userAns = input.nextInt();
	return userAns;
}
public static boolean isAnswerCorrect(int actualAns, int studAns) {	// Checks if answer is correct
	if(actualAns == studAns)
		return true;
	else
		return false;
}
public static void displayCorrectResponse(int type){	// Prints random correct response
	if(type==1)
		System.out.println("Very good!");
	if(type==2)
		System.out.println("Excellent!");
	if(type==3)
		System.out.println("Nice Work!");
	if(type==4)
		System.out.println("Keep up the good work!");
}
public static void displayIncorrectResponse(int type){	// Prints random incorrect response
	if(type==1)
		System.out.println("No. Please try again.");
	if(type==2)
		System.out.println("Wrong. Try once more.");
	if(type==3)
		System.out.println("Don't give up!");
	if(type==4)
		System.out.println("No. Keep trying.");
}
public static void displayCompletionMessage(int numofCorrect){	// Prints completion message
	int grade = numofCorrect*(10);	// Calculates student's grade
	Scanner input = new Scanner(System.in);
	System.out.println("Your quiz score is "+grade+"!");
	if(grade >= 75)		// Determines if student passed the quiz
		System.out.println("Congratulations, you are ready to go to the next level!");
	if(grade<75)
		System.out.println("Please ask your teacher for extra help.");
	System.out.println("Would you like to try again? Press 1 for Yes, Press 2 for No.");	// Asks Student if they would like to take the quiz again
	int choice = input.nextInt();
	if(choice == 1)
		quiz();
	if(choice == 2)
		System.exit(0);
	input.close();
}
public static int readDifficulty(){		// Reads student's difficulty choice
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	return choice;
}
public static int generateQuestionArguement(int choice){	// Generates a random number based on student's difficulty choice
	SecureRandom randNum = new SecureRandom();
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
public static int readProblemType() {		// Reads student's problem type choice
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	return choice;
}
}