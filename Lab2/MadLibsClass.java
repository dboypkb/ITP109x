/* 
 *  Darren Pouliot
 *  dpouliot@usc.edu
 *  ITP 109 - Spring 2013
 *  Lab 2: Creates a MadLib based on User's input
 */

import java.util.Scanner;

public class MadLibsClass {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter a name: ");
		String name = keyboard.nextLine();
		
		System.out.print("Enter a color: ");
		String color = keyboard.nextLine();
		
		System.out.print("Enter a gender: ");
		String gender = keyboard.nextLine();
		
		System.out.print("Enter a country: ");
		String country = keyboard.nextLine();
		
		System.out.print("Enter a number: ");
		int number = keyboard.nextInt();
		
		System.out.println(" How to make these words into a story? Perhaps it begins in \"" + country + "\".\n" 
							+ " But there must be a hero. Their name was \"" + name 
							+ "\" and they must have \n been \"" + number + "\" years old by then. \""
							+ color + "\" skies surrounded them as the still \n young \"" + gender 
							+ "\" hero set out." + " And then... I forget the rest.");
		
		keyboard.close();
	}

}
