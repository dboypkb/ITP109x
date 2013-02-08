/* 
 *  Darren Pouliot
 *  dpouliot@usc.edu
 *  ITP 109 - Spring 2013
 *  Lab 3: Determines change dispensed given 25-100c input
 */

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int price	  = 0;
		int change    = 0; final int DOLLAR  = 100;
		int quarters  = 0; final int QUARTER = 25;
		int dimes 	  = 0; final int DIME    = 10;
		int nickels   = 0; final int NICKEL  = 5;
		int pennies   = 0; 
		int remainder = 0;
		
		System.out.println("Vending Machine");
		System.out.print("Enter the price an item in cents (25-100 only): ");
		price = keyboard.nextInt();
		
		change = DOLLAR - price;
		
		quarters = change / QUARTER; // Finds number of quarters from "change"
		remainder = change % QUARTER; // Stores remainder in "remainder"
		
		dimes = remainder / DIME; // Finds number of dimes from "remainder"
		remainder = remainder % DIME; // Stores remainder in "remainder"
		
		nickels = remainder / NICKEL; // Finds number of nickels in "remainder"
		remainder = remainder % NICKEL; // Stores remainder in "remainder"
		
		pennies = remainder; // Pennies must be value of "remainder"

		System.out.println("Your change is " + change + " cents, divided up into: ");
		
		System.out.println( "Quarters: " + quarters + "\n" +
						    "Dimes:    " + dimes    + "\n" +
						    "Nickels:  " + nickels  + "\n" +
						    "Pennies:  " + pennies );
		
		keyboard.close();
	}

}
