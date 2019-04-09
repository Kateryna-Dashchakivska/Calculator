package com.kateProjects.calculator;

public class OperationFactory {

	static Operation createOperationFromSymbol (String symbol) {

		switch (symbol) {
			case "+":
				return new Addition();
			case "-":
				return new Substraction();
			case "*":
				return new Multiplication();
			case "/":
				return new Division();
			default:
				System.out.println("Unsupported operation!");
		}
		return null;
	}

}
