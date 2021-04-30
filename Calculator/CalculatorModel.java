
/*
File name: 			CalculatorSplashScreen
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		1 part 2
Date:			    2020-03-06
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class it to add all of the logic of the calculator
 					and then display the results to calling class
					
*/

package Calculator;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Purpose of this class it to add all of the logic of the calculator and then
 * display the results to calling class
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see CalculatorModel.java
 * @since 1.8
 */
public class CalculatorModel {

	/**
	 * Arithmetic operator used in calculations
	 */
	private String arithmeticOperation;

	/**
	 * The operational mode that the Calculator will be operating in
	 */
	private String operationalMode;

	/**
	 * The precision the result of Calculations will be shown in
	 */
	private String floatingPointPrecision;

	/**
	 * The error state of the Calculator if true error has happened
	 */
	private boolean errorState;

	/**
	 * The first number to be calculated on
	 */
	private String number1;

	/**
	 * The second number to be calculated on
	 */
	private String number2;

	/**
	 * The result of the big Decimal calculations
	 */
	private BigDecimal r1;

	/**
	 * The result of the calculations as a big Integer
	 */
	private BigInteger resulti;

	/**
	 * The return String to calling method to display contents of results
	 */
	private String resultTrue;

	/**
	 * Error string to display contents of error that has happened
	 */
	private String errorMessage;

	/**
	 * The purpose of this constructor is to set the default state of the values
	 * used in this class
	 * 
	 */
	CalculatorModel() {

		operationalMode = ".00";
		floatingPointPrecision = ".00";
		number1 = "0";
		number2 = "0";
		errorState = false;// by default error state is false
	}

	/**
	 * The purpose of this setter is to get the value of the first number from
	 * calculator view controller
	 * 
	 * @param number1 first number passed in
	 */
	public void setOperands1(String number1) {
		this.number1 = number1;
	}

	/**
	 * The purpose of this setter is to get the value of the second number from
	 * calculator view controller
	 * 
	 * @param number2 first number passed in
	 */
	public void setOperands2(String number2) {
		this.number2 = number2;

	}

	/**
	 * The purpose of this class it to set the arithmetic operation from another
	 * class
	 * 
	 * @param arithmeticOperation operator sign
	 */
	public void setArithmeticOperation(String arithmeticOperation) {
		this.arithmeticOperation = arithmeticOperation;

	}

	/**
	 * The purpose of this class it to set the operatinalMode from another class
	 * 
	 * @param operationalMode The mode in which the class will be operating in
	 */
	public void operationalMode(String operationalMode) {
		this.operationalMode = operationalMode;
	}

	/**
	 * The purpose of this class it to set the precision the calculator will be
	 * dealing with
	 * 
	 * @param floatingPointPrecision how many decimal points that will be kept
	 */
	public void floatingPointPrecision(String floatingPointPrecision) {
		this.floatingPointPrecision = floatingPointPrecision;
		// System.out.print(floatingPointPrecision);
	}

	/**
	 * The purpose of this class it to return the floating point number to calling
	 * class
	 * 
	 * @return floating point number
	 */
	public String getFloatingPointPrecision() {// used in another class
		return floatingPointPrecision;
	}

	/**
	 * The purpose of this class it to return the calculated value from calculate
	 * method
	 * 
	 * @return calculate
	 */
	public String getResult() {// this will return the calculate method which will be string
		return calculate();
	}

	/**
	 * The purpose of this class it to set the error state of the method
	 * 
	 * @param errorState if program encounters error this is set to true
	 */
	public void setErrorState(boolean errorState) {
		this.errorState = errorState;
	}

	/**
	 * The purpose of this class it to get the error state of the class
	 * 
	 * @return
	 */
	public boolean getErrorState() {
		return errorState;
	}

	/**
	 * The purpose of this class is to logically find out the result of the two
	 * numbers that will be operated on and return said result to calling method
	 * 
	 * @return calculate
	 */
	private String calculate() {

		if (!number1.equals("0") && number2.equals("0") && arithmeticOperation.equals("/")) {

			setErrorState(true);// set error stat to true

			errorMessage = "Cannot Divide By Zero";

		} else if (number1.equals("0") && number2.equals("0") && arithmeticOperation.equals("/")) {

			setErrorState(true);// set error stat to true

			errorMessage = "Result is undefined";

		} else {

			MathContext mc = new MathContext(10, RoundingMode.HALF_UP);// used to round numbers if division results in
																		// repeating non terminating result

			if (operationalMode.equals("HEX")) {

				if (number2.equals("")) {// if you are doing 2+= format

					BigInteger b1 = new BigInteger(number1); // Or BigInteger.ONE
					resulti = new BigInteger("0"); // Or BigInteger.ONE

					switch (arithmeticOperation) {

					case "+":
						resulti = b1.add(b1);
						break;
					case "-":
						resulti = b1.subtract(b1);
						break;
					case "*":
						resulti = b1.multiply(b1);
						break;
					case "/":
						resulti = b1.divide(b1);
						break;

					}

				} else {// if user is putting in information in format 2+2=

					BigInteger b1i = new BigInteger(number1, 16); // Or BigInteger.ONE
					BigInteger b2i = new BigInteger(number2, 16); // Or BigInteger.ONE
					resulti = new BigInteger("0");

					switch (arithmeticOperation) {// determin operation to be used

					case "+":

						resulti = b1i.add(b2i);
						break;

					case "*":
						resulti = b1i.multiply(b2i);
						break;

					case "/":
						resulti = b1i.divide(b2i);
						break;

					case "-":
						resulti = b1i.subtract(b2i);
						break;
					}

				}

				resultTrue = resulti.toString(16);// show result as a hex value

			}

			if (!operationalMode.equals("HEX")) {// if operationinal mode is not HEX

				if (number2.equals("")) {// if you are doing 2+=

					BigDecimal b1 = new BigDecimal(number1); // Or BigInteger.ONE
					r1 = new BigDecimal("0"); // Or BigInteger.ONE

					switch (arithmeticOperation) {

					case "+":
						r1 = b1.add(b1);
						break;
					case "-":
						r1 = b1.subtract(b1);
						break;
					case "*":
						r1 = b1.multiply(b1);
						break;
					case "/":
						r1 = b1.divide(b1);
						break;

					}

					resultTrue = r1.toString();// set result to result of calculations

				} else {
					BigDecimal b1 = new BigDecimal(number1); // Or BigInteger.ONE
					BigDecimal b2 = new BigDecimal(number2); // Or BigInteger.ONE
					r1 = new BigDecimal("0"); // Or BigInteger.ONE

					// if(!operationalMode.equals("HEX")) {

					switch (arithmeticOperation) {

					case "+":

						r1 = b1.add(b2);
						break;

					case "*":
						r1 = b1.multiply(b2);
						break;

					case "/":
						r1 = b1.divide(b2, mc);// mc will only take the fist 10 decimals after the . operator
						break;

					case "-":
						r1 = b1.subtract(b2);
						break;
					}

					switch (floatingPointPrecision) {// change the format of answer to specified format

					case ".0":
						resultTrue = String.format("%.1f", r1);// 1 value after dot precision
						break;
					case ".00":
						resultTrue = String.format("%.2f", r1);// 2 value after dot precision
						break;

					case "Sci":
						resultTrue = String.format("%E", r1);// answer is put in scientific notation
						break;

					case "HEX":
						resultTrue = String.format("%.0f", r1);// No dot operator in results
						break;
					}

				} // end of if

			}

			if (resultTrue.length() >= 29) {// if result is larger then display display an error message

				setErrorState(true);// set method to true, there is error in calculator

				errorMessage = "Result is to large";

			}

		}

		if (errorState == true) {// if an error occurred then return the error message

			setErrorState(false);// set the error state back to false, no errors.
			return errorMessage;

		} else {

			return resultTrue;// If no errors in calculations return results of calculated values
		}

	}// end of calculate

}
