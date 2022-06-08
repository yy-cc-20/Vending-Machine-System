package Presentation;

import java.util.Scanner;

public class ConsoleInput {
	
	private static final Scanner scanner = new Scanner(System.in); // Singleton pattern
	
	// @return 0 or positive int
	public static int askInt(String info) {
		while (true) {
			System.out.printf("Enter %s: ", info);
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter digits only.");
			}
		}
	}
	
	// @return 0 or positive double
	public static double askPositiveDouble(String info) {
		double input;
		String errorMessage = "Please enter a positive number.";
		
		while (true) {
			System.out.printf("Enter %s: ", info);
			try {
				input = Double.parseDouble(scanner.nextLine());
				if (input < 0) {
					System.out.println(errorMessage);
				} else {
					return input;
				}
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}
}
