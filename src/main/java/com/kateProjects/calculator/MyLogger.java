package com.kateProjects.calculator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.logging.FileHandler;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;

public class MyLogger {
	
	static void appendUsingPrintWriter(String filePath, String message) {
		File file = new File("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log");
		FileWriter fr = null;
		BufferedWriter br = null;
		PrintWriter pr = null;
		try {
			// to append to file, you need to initialize FileWriter using below constructor
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.print(message);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

//	static boolean logMessage(String message) {
//
//		boolean result = false;
//		Logger logger = Logger.getLogger("Calculation"); 
//
//		try {
//			//Logger need file to log into
//			FileHandler fh = new FileHandler("C:\\Users\\Kateryna_Dashchakivs\\eclipse-workspace\\Calculator\\src\\ConsoleCalculator/Calculation.log");
//			logger.addHandler(fh);
//			SimpleFormatter formatter = new SimpleFormatter();  
//	        fh.setFormatter(formatter); 
//
//			//Log message to logger file
//			logger.info(message);
//			result = true;
//
//		} catch (SecurityException e1) {
//			e1.printStackTrace();
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
//		return result;
//	}
}
