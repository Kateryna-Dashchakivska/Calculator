package com.kateProjects.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
        @Test
         public void basicAdditionTest () {
            String symbol = "+";
            Operation operation = OperationFactory.createOperationFromSymbol(symbol);
            assertNotNull ("Operation must not be null", operation);

            double operand1 = 10;
            double operand2 = 15;
            double result = operation.perform(operand1, operand2);
            assertEquals ("Incorrect result of addition operation!", 25 , result , 0.000001);
        }

        @Test
        public void basicSubstructionTest () {
            String symbol = "-";
            Operation operation = OperationFactory.createOperationFromSymbol(symbol);
            assertNotNull ("Operation must not be null", operation);

            double operand1 = 15;
            double operand2 = 5;
            double result = operation.perform(operand1, operand2);
            assertEquals ("Incorrect result of substraction operation!", 10 , result , 0.000001);
        }

        @Test
        public void basicMultiplicationTest () {
            String symbol = "*";
            Operation operation = OperationFactory.createOperationFromSymbol(symbol);
            assertNotNull ("Operation must not be null", operation);

            double operand1 = 10;
            double operand2 = 10;
            double result = operation.perform(operand1, operand2);
            assertEquals ("Incorrect result of multiplication operation!", 100 , result , 0.000001);
        }

        @Test
        public void basicDivisionTest () {
            String symbol = "/";
            Operation operation = OperationFactory.createOperationFromSymbol(symbol);
            assertNotNull ("Operation must not be null", operation);

            double operand1 = 20;
            double operand2 = 10;
            double result = operation.perform(operand1, operand2);
            assertEquals ("Incorrect result of division operation!", 2 , result , 0.000001);
    }

        @Test
        public void invalidOperationTest () {
            String[] invalidOperations = {"@", "1", "#", "?", "++", "kate", ">", ";", ")", "^", ""};
            Operation operation;
            for (String operationSymbol : invalidOperations) {
                operation = OperationFactory.createOperationFromSymbol (operationSymbol);
                assertNull ("Operation created from symbol: \'" + operationSymbol + "\' must be null", operation);
            }
        }

        @Test
        public void validOperationTest () {
            String [] validOperations = {"+", "-", "*", "/"};
            Operation operation;
            for (String operationSymbol: validOperations) {
                operation = OperationFactory.createOperationFromSymbol(operationSymbol);
                assertNotNull ("Operation created from symbol: \'" + operationSymbol + "\' must not be null", operation);
            }
        }
}