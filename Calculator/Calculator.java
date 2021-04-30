/*
File name: 			Calculator
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		1 part 2
Date:			    2020-03-06
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class it to call the splash screen class. Then make a frame
 					set its parameters then call the class that add to the GUI contents.
*/

package Calculator;

import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Purpose of this class it to call the splash screen class. Then make a frame
 * set its parameters then call the class that add to the GUI contents.
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see Calculator.java
 * @since 1.8
 */
public class Calculator {

	/**
	 * Purpose of this is to run the main method of program
	 * 
	 * @param args arguments for main program
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculatorSplashScreen showSplashWindow = new CalculatorSplashScreen(5000);// set time to 5 seconds

		showSplashWindow.showSplashWindow();// call instance of method showSplashWindow

		CalculatorViewController c = new CalculatorViewController();// make instance of class CalculatorViewController

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();// create j frame object
				frame.pack();//

				frame.setTitle("Calculator");

				frame.setSize(340, 500);// set size

				frame.setMinimumSize(new Dimension(340, 500));// set minimum size for JFrame

				frame.setLocationRelativeTo(null);// set location to center of screen

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when click x JFrame will exit

				frame.setContentPane(c);// sets content pane of the frame to a CalculatorViewController object

				frame.setVisible(true);// make frame visible
			}
		});

	}

}// end of class
