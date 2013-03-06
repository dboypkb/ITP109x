/* 
 *  Darren Pouliot
 *  dpouliot@usc.edu
 *  ITP 109 - Spring 2013
 *  Lab 6: Displays the either the largest number or the factorial of the number(s) entered
 */

import java.util.Scanner;

public class Methods {

	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) 
	{

		int n = Methods.presentMenu();

		while (n == 1) 
		{
			n = Methods.presentMenu();
		}

		keyboard.close();
	}

	static int presentMenu()
	{
		int factorialInput;

		int input = 0;

		// Prompts user to select a menu option
		System.out.println(
				"Enter the number of an option below: \n" +
				" 1: Largest Number \n" +
				" 2: Factorial \n" +
				"-1: Quit");

		input = keyboard.nextInt();
		String garbage = keyboard.nextLine();

		switch (input)
		{

		case 1: {

			System.out.println(Methods.getLargestNumber());
			return 1;

		}
		case 2: {

			System.out.print("Enter an integer to find its factorial: ");
			factorialInput = keyboard.nextInt();
			garbage = keyboard.nextLine();

			// Confirms input is valid before calling getFactorial
			if (factorialInput >= 0){
				System.out.println("The factorial of \"" + factorialInput + "\" is \"" + Methods.getFactorial(factorialInput) + "\". \n");
				return 1;
			}
			else {
				System.out.println("Invalid Input. Only numbers greater than or equal to zero may be entered. \n");
				return 1;
			}


		}
		case -1: {

			System.out.println("Have a nice day!");
			return 0;

		}
		default: {

			System.out.println("Invalid Input. Please try again. \n");
			return 1;
		}
		}
	}

	static String getLargestNumber()
	{

		int n = 0;
		int factorialInput = 0;
		int largestNumber = -1;

		String largestNumberString = "No factorial entered";

		while (n == 0) 
		{

			// Prompts user to enter an integer
			System.out.println("Enter an integer greater than or equal to zero, or -1 to quit: ");
			factorialInput = (int)keyboard.nextFloat();
			String garbage = keyboard.nextLine();

			// Checks if value user entered is greater than any previous (or default) value and stores it if it is
			if (factorialInput != -1)
			{
				if (factorialInput >= largestNumber)
				{
					largestNumber = factorialInput;
				}
			}

			// Displays largest factorialInput entered
			else if (factorialInput == -1 && largestNumber != -1) 
			{
				largestNumberString = "The largest factorialInput you entered was: " + largestNumber + "\n";
				n = 1;
			}

			// Skips Output if user quits without ever entering a factorialInput
			else if (factorialInput == -1 && largestNumber == -1) 
			{
				largestNumberString = "You did not enter any numbers";
				n = 1;
			}
		}

		return largestNumberString;
	}

	static long getFactorial(int factorialInput)
	{

		long n = 0;
		long finalNumber = 0;

		// Factorial Function
		if (factorialInput > 0 && factorialInput != 1) 
		{

			for (n = factorialInput - 1; n > 1; n--) 
			{		

				finalNumber = (long)factorialInput * n;
				factorialInput = (int)finalNumber;

			}
		}

		// Factorial Special Cases
		// 1! = 1
		else if (factorialInput == 1) 
		{
			finalNumber = 1;;
		}
		// 0! = 1
		else if (factorialInput == 0) 
		{
			finalNumber = 1;
		}
		// Input Error
		else if (factorialInput < 0) 
		{
			finalNumber = -1;
		}

		return finalNumber;
	}
}

