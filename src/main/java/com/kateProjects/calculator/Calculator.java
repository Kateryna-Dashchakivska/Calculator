package com.kateProjects.calculator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator {

	public void startSession() {

		String filePath = "C:\\Users\\Kateryna_Dashchakivs\\IdeaProjects\\calculator/Calculation.log";

		System.out.println("Starting new calculation session:");
		
		//Read first number
		double operand1 = UserInputReader.readNumber();
//		MyLogger.logMessage("Your calculation: " + "\r" + operand1);
		MyLogger.appendUsingPrintWriter(filePath, "Your calculation: " + "\r" + operand1);

		double result = operand1;
		
		boolean finished = false;
		while (finished == false) {
			
			//Read operation
			Operation operation = null;
			while (operation == null) {
				String symbol = UserInputReader.readOperation();
				MyLogger.appendUsingPrintWriter(filePath, " " + symbol);
				if (symbol.equals("=")) {
					finished = true;
					break;
				} else {
					operation = OperationFactory.createOperationFromSymbol(symbol);
				}
			}
			if (finished == false) {
				//Read next number
				double operand2 = UserInputReader.readNumber();

				MyLogger.appendUsingPrintWriter(filePath, " " + operand2);
				Utility utility = new Utility();
				//Perform operation    //(operand2 != 0.0)
				if (!(operation.getClass().isInstance(Division.class)) && !(utility.isZero(operand2)) ){
					result = operation.perform(result, operand2);
					finished = false;
				}
				else {
					System.out.println("\nYou are not allowed to divide by zero!");
					finished = false;
				}

			}
		}
		
		System.out.println("________________________________\n");
		System.out.println("Your result is: " + result);
		System.out.println("________________________________\n");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		MyLogger.appendUsingPrintWriter(filePath, " " + result
				+ "\rDate of the calculation: " + dateFormat.format(date) + "\r\r");

		System.out.println("Start new session?");
		if (UserInputReader.readUserAgree()) {
			startSession();
		} else {
			System.out.println("Thanks for using my awesome calculator!");
//			System.exit(0);
		}
	}
}
