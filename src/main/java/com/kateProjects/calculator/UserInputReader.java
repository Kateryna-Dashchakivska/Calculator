package com.kateProjects.calculator;
import java.util.Scanner;

public class UserInputReader {

	static double readNumber() {
		System.out.println("Please enter number:");
		Scanner scan = new Scanner(System.in);
		double result = 0;
		boolean isNumberValid = false;

		while (isNumberValid == false) {
			if (scan.hasNextDouble()) {
				result = scan.nextDouble();
				if (result >= -20 && result <= 20) {
					//System.out.println("\n" + result + " is correct!");
					isNumberValid = true;
				} else {
					System.out.println("\n" + result + " is not allowed number. Allowed number should be in the following range: [-20; 20]. Please try again.\n");
				}
			} else {
				System.out.println("\n" + scan.next() + " is not a number. Please try again.\n" );
			}
		}
		return result;
	}

	static String readOperation() {
		String userOperation = null;
		Scanner scan = new Scanner(System.in);
		boolean isOperationValid = false;
		while (isOperationValid == false) {
			System.out.print("\nSelect valid operation: [*], [/], [+], [-], \nor [=] to finish\n ");
			if(scan.hasNextLine()) {
				userOperation = scan.nextLine();
				isOperationValid = true;	
				return userOperation;
			}
		}
		return userOperation;

	}

	static boolean readUserAgree() {
		System.out.println("Enter 'yes' to agree");
		Scanner scan = new Scanner(System.in);
		String answer = scan.nextLine();
		return answer.equalsIgnoreCase("yes");
	}
}