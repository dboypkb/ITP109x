/* 
 *  Darren Pouliot
 *  dpouliot@usc.edu
 *  ITP 109 - Spring 2013
 *  Lab 4: Converts temperature input to different scale with Significant Figures
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class ConvertTemp {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Enter a temperature in degrees (ex. 29.6): ");
		double temperature = keyboard.nextDouble();

		// Collects \n from previous input to prevent an error later (unused)
		String garbage = keyboard.nextLine();

		System.out.print("Enter C for Celcius or F for Fahrenheit: ");
		String scale = keyboard.nextLine();

		double convertedTemp = 0;

		// Sets Scale to Fahrenheit if neither "C" nor "F" is input
		if (!scale.equalsIgnoreCase("C") && !scale.equalsIgnoreCase("F")) 
		{
			System.out.println("Invalid input. You didn't enter \'C\' or \'F\'. I'll assume you meant Fahrenheit.");
			scale = "F";	
		}

		// Converts Celsius to Fahrenheit
		if (scale.equalsIgnoreCase("C"))
			convertedTemp = (9 * temperature / 5) + 32;

		// Converts Fahrenheit to Celsius
		if (scale.equalsIgnoreCase("F")) 
			convertedTemp = (5 * (temperature - 32)) / 9;

// Adjusts Output for Significant Figures (ignores certainty with 0s after decimal)
// Independent of Assignment, Just for Accuracy
		// Gets # of Digits Before Decimal
		int intTemp = (int)temperature;
		String intTempString = String.valueOf(intTemp);
		int intTempLength = intTempString.length();

		// Gets # of digits after decimal + 1 (Has to include decimal in count)
		String tempString = String.valueOf(temperature);
		String modTempString = tempString.substring(intTempLength);
		int tempStringLength = modTempString.length();

		// Declares variables for conditional statements to follow
		double absTemperature = temperature;
		int sigFigCount = 0;

		// Creates absolute value of temperature input to be able to check if value entered is between 0 and 1
		if (temperature < 0)
			absTemperature = (temperature * -1);

		// Corrects Sig. Fig. Count by ignoring zero before decimal if value entered is between 0 and 1
		// Corrects Sig. Fig. Count by adjusting for previously counting the decimal as a digit as well
		if (absTemperature < 1)
			sigFigCount = (intTempLength + tempStringLength - 2);
		else 
			sigFigCount = (intTempLength + tempStringLength - 1);

		// Corrects Sig. Fig. Count by assuming a whole number entered is certain to only its # of digits (and not one extra)
		// Ex. If "32" is entered, that's two sig. figs., not three automatically inserted by Scanner.nextDouble function (32.0)
		if (temperature % 1 == 0)
			sigFigCount = sigFigCount - 1;

		// Creates the absolute value of converted temperature to be able to correctly get its # of digits
		double absConvertedTemp = 0;
		if (convertedTemp < 0)
			absConvertedTemp = (convertedTemp * -1);
		else
			absConvertedTemp = convertedTemp;

		// Gets the # of digits before decimal
		int convertedTempInt = (int)absConvertedTemp;
		String convertedTempIntString = String.valueOf(convertedTempInt);
		int convertedTempIntLength = convertedTempIntString.length();

		// Calculates the # of digits after the decimal required for the correct number of Sig. Figs.
		int decimalPlaceCount = sigFigCount - convertedTempIntLength;

		DecimalFormat df = null;
		if (decimalPlaceCount < 1)
			df = new DecimalFormat("0");
		if (decimalPlaceCount == 1)
			df = new DecimalFormat("0.0");
		if (decimalPlaceCount == 2)
			df = new DecimalFormat("0.00");
		if (decimalPlaceCount == 3)
			df = new DecimalFormat("0.000");
		if (decimalPlaceCount == 4)
			df = new DecimalFormat("0.0000");
		if (decimalPlaceCount >= 5)
			df = new DecimalFormat("0.00000");

// Ends Significant Figure Determination Function

		if (scale.equalsIgnoreCase("F")) // Prints Out Fahrenheit -> Celsius Conversion
			System.out.println(temperature + " degrees Fahrenheit is " + df.format(convertedTemp) + " degrees Celsius");
		else // Prints Out Celsius -> Fahrenheit Conversion
			System.out.println(temperature + " degrees Celsius is " + df.format(convertedTemp) + " degrees Fahrenheit");

		keyboard.close();
	}

}
