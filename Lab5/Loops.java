/* 
 *  Darren Pouliot
 *  dpouliot@usc.edu
 *  ITP 109 - Spring 2013
 *  Lab 5: Displays the largest number entered or the factorial of the number entered
 */

import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		int input = 0;
		while (input != -1) {
			System.out.println("\nPlease enter one of the following choices: \n" 
					+ " 1 --> Largest Number \n" 
					+ " 2 --> Factorial \n" 
					+ "-1 --> Quit" );

			// Gets user's option choice
			input = keyboard.nextInt();

			// Captures the \n from the previous input
			String garbage = keyboard.nextLine();

			switch (input) {

			// Largest Number Case
			case 1: {

				int n = 0;
				int number = 0;
				int largestNumber = -1;
				while (n == 0) {

					System.out.println("Enter an integer greater than or equal to zero, or -1 to quit: ");
					number = (int)keyboard.nextFloat();
					garbage = keyboard.nextLine();

					// Checks if value user entered is greater than any previous (or default) value and stores it if it is
					if (number != -1){
						if (number >= largestNumber)
							largestNumber = number;
					}

					// Displays largest number entered
					if (number == -1) {
						System.out.println("The largest number you entered was: " + largestNumber + "\n");
						n = 1;
					}

					// Skips Output if user quits without ever entering a number
					if (number == -1 && largestNumber == -1)
						break;

				}
				break;	
			}
			// Factorial Case
			case 2: {

				long n = 0;
				long number = 0;
				long originalNumber = 0;
				long finalNumber = 0;

				System.out.print("Enter an integer for which to calculate the factorial of: ");
				number = (int)keyboard.nextFloat();
				garbage = keyboard.nextLine();

				originalNumber = number;

				// Factorial Function
				if (number > 0 && number != 1) {

					for (n = number - 1; n > 1; n--) {		

						finalNumber = number * n;
						number = finalNumber;

					}

					System.out.println(originalNumber + "! = " + finalNumber);
				}
				// Factorial Special Cases
				if (number == 1)
					System.out.println("1! = 1");
				if (number == 0) 
					System.out.println("0! = 1");
				// User Error Statement
				if (number < 0)
					System.out.println("Error: Number entered is less than zero");

				break;
			}

			// Displays Error when Input is not 1, 2, or -1
			default: {

				if (input != -1)
					System.out.println("Invalid Input. Please try again.");

				break;
			}

			}
		}

		System.out.println("Have a nice day!");

		keyboard.close();
	}
}

