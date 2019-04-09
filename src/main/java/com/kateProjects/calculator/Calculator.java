package com.kateProjects.calculator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator {

	public static void startSession() {

		System.out.println("Starting new calculation session:");
		
		//Read first number
		double operand1 = UserInputReader.readNumber();
//		MyLogger.logMessage("Your calculation: " + "\r" + operand1);
		MyLogger.appendUsingPrintWriter("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log", "Your calculation: " + "\r" + operand1);

		double result = operand1;
		
		boolean finished = false;
		while (finished == false) {
			
			//Read operation
			Operation operation = null;
			while (operation == null) {
				String symbol = UserInputReader.readOperation();
				MyLogger.appendUsingPrintWriter("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log", " " + symbol);
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
				MyLogger.appendUsingPrintWriter("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log", " " + operand2);

				//Perform operation
				result = operation.perform(result, operand2);
			}			
		}
		
		System.out.println("________________________________\n");
		System.out.println("Your result is: " + result);
		System.out.println("________________________________\n");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		MyLogger.appendUsingPrintWriter("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log", " " + result
				+ "\r\nDate of the calculation: " + dateFormat.format(date));

		System.out.println("Start new session?");
		if (UserInputReader.readUserAgree()) {
			startSession();
		} else {
			System.out.println("Thanks for using my awesome calculator!");
//			System.exit(0);
		}
	}
}
