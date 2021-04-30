
/*
File name: 			CalculatorViewController
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		1 part 2
Date:			    2020-03-06
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class it to build GUI Calcualtor and add it to the frame made in  Calcualtor class. 
Class list: 		CalcualtorViewController,Controller
*/

package Calculator;

import java.awt.BorderLayout;

import java.lang.String;//maybe delete

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * Purpose of this class it to build GUI Calculator and add it to the frame made
 * in Calculator class.
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see CalculatorViewController.java
 * @since 1.8
 */
public class CalculatorViewController extends JPanel {

	/**
	 * Display field one for Calculator display
	 */
	private JTextField display1; // the calculator display1 field reference
	/**
	 * Display field two for Calculator display
	 */
	private JTextField display2; // the calculator display2 field reference

	/**
	 * The error Display JLabel for Calculator
	 */
	private JLabel error; // the mode/error display label reference
	/**
	 * the decimal point button reference for JButton
	 */
	private JButton dotButton;// the decimal point (dot) button reference
	/**
	 * array of JButtons called hex buttons to hold many JButtons of close same
	 * fields
	 */
	private JButton[] hexButtons; // reference to container for alphabetical hex buttons

	/**
	 * Array which holds the fields to the hexButtons label for JButtons
	 * 
	 * @holder "A", "B", "C", "D", "E", "F", "7", "8", "9", "4", "5", "6", "1", "2",
	 *         "3", ".","0", "\u00B1"
	 */
	private static String holder[] = { "A", "B", "C", "D", "E", "F", "7", "8", "9", "4", "5", "6", "1", "2", "3", ".",
			"0", "\u00B1" };

	/**
	 * This Constructor builds the components to the GUI Adding various
	 * implementations of Buttons Panels check boxes radio buttons and textFields
	 * and adding them to panels to then be added to the main frame of program
	 */
	public CalculatorViewController() {

		Controller controller = new Controller();// make an instance to the Controller class

		hexButtons = new JButton[18];// make 18 JButtons contained in hex buttons array

		setLayout(new BorderLayout(5, 0)); // set layout for whole Calculator set gaps to 0 vertical 5 horizontal
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); // boarders to 5 all around
		setBackground(Color.black);// set background to black

		JPanel north = new JPanel();// create north panel to be added to main panel
		north.setLayout(new BorderLayout());
		north.setBackground(Color.yellow);// make north panel yellow as per specifications

		/* F Label for calculator */
		error = new JLabel("F", SwingConstants.CENTER);
		error.setFont(new Font("defualt", Font.BOLD, 17));
		error.setOpaque(true);
		error.setBackground(Color.yellow);
		error.setBorder(new MatteBorder(0, 1, 0, 5, Color.black));
		error.setPreferredSize(new Dimension(55, 55));

		north.add(error, BorderLayout.WEST);// add F JLabel to left of north panel

		dotButton = new JButton("\u27f8");// unicode for left pointing arrow
		dotButton.setFont(new Font("defualt", Font.BOLD, 17));

		/* make j button transparent */
		dotButton.setBorder(null);
		dotButton.setBorderPainted(false);
		dotButton.setContentAreaFilled(false);
		dotButton.setOpaque(true);
		dotButton.addActionListener(controller);

		dotButton.setMnemonic(KeyEvent.VK_B);// make button react to mnemonic alt-b keyboard press

		dotButton.setBackground(Color.yellow);
		dotButton.setBorder(new MatteBorder(0, 5, 0, 1, Color.black));
		dotButton.setPreferredSize(new Dimension(55, 55));

		/* Text field that starts out with display of 0.0 */
		display1 = new JTextField("0.0");
		display1.setPreferredSize(new Dimension(14, 30)); // set dimensions 14 length 30 height
		display1.setHorizontalAlignment(SwingConstants.RIGHT);// text align right
		display1.setBackground(Color.white);
		display1.setEditable(false);// can't edit this field
		display1.setBorder(BorderFactory.createEmptyBorder()); // no boarder for JText field

		/* Text field that does not display anything */
		display2 = new JTextField("");
		display2.setPreferredSize(new Dimension(14, 30)); // set dimensions 14 length 30 height
		display2.setHorizontalAlignment(SwingConstants.RIGHT);// text align right
		display2.setBackground(Color.white);
		display2.setEditable(false);// can't edit this field
		display2.setBorder(BorderFactory.createEmptyBorder()); // no boarder for JText field

		// Panel to contain the JTextFields that will contain north and center
		JPanel textPanel = new JPanel((new BorderLayout(0, 0)));
		textPanel.setBackground(Color.yellow);// set panel background color to yellow

		// Create green hex button
		JCheckBox hex = new JCheckBox("HEX");
		hex.setFont(new Font("defualt", Font.PLAIN, 10));
		hex.setOpaque(true);
		hex.setBackground(Color.green);
		hex.addActionListener(controller);// make it display hex when clicked
		hex.setPreferredSize(new Dimension(50, 15));

		// JPanel to contain the radio buttons and the Hex JButton
		JPanel southOfNothPanel = new JPanel();
		southOfNothPanel.setLayout(new BorderLayout());// boarder will be border layout
		southOfNothPanel.setBackground(Color.BLACK);// background black for radio button hex panel per specifications

		southOfNothPanel.setBorder(new EmptyBorder(8, 0, 0, 0));// create empty boarder per specifications

		// create radio button of .0
		JRadioButton radioOne = new JRadioButton(".0");
		radioOne.setFont(new Font("defualt", Font.PLAIN, 10));
		radioOne.setOpaque(true);
		radioOne.setBackground(Color.yellow);
		radioOne.addActionListener(controller);// add action listener
		radioOne.setPreferredSize(new Dimension(45, 20));

		// create radio button of .00
		JRadioButton radioTwo = new JRadioButton(".00");
		radioTwo.setFont(new Font("defualt", Font.PLAIN, 10));
		radioTwo.setOpaque(true);
		radioTwo.setBackground(Color.yellow);
		radioTwo.addActionListener(controller);// add action listener
		radioTwo.setPreferredSize(new Dimension(45, 20));

		// create radio button of Sci
		JRadioButton radioThree = new JRadioButton("Sci");
		radioThree.setFont(new Font("defualt", Font.PLAIN, 10));
		radioThree.setOpaque(true);
		radioThree.setBackground(Color.yellow);
		radioThree.addActionListener(controller);// add action listener
		radioThree.setPreferredSize(new Dimension(45, 20));

		// Panel of flow layout that will hold the 3 radio buttons which will all be of
		// equal spacing between eachother
		JPanel flowPanelForRadioButtons = new JPanel(new FlowLayout());
		flowPanelForRadioButtons.setBackground(Color.yellow);
		flowPanelForRadioButtons.setBorder(BorderFactory.createEmptyBorder(0, -5, 0, 0));

		/* make 1 check box and 3 radio buttons in a same group */
		ButtonGroup group1 = new ButtonGroup();

		// add each button to the same group
		group1.add(radioOne);
		group1.add(radioTwo);
		group1.add(radioThree);
		group1.add(hex);

		radioTwo.setSelected(true);// default selected will be on middle radio button when application starts

		// add the 3 radio buttons to the flow layout panel
		flowPanelForRadioButtons.add(radioOne);
		flowPanelForRadioButtons.add(radioTwo);
		flowPanelForRadioButtons.add(radioThree);

		// Add the hex button and the radio buttons to the panel that will be under
		// JText Fields
		southOfNothPanel.add(hex, BorderLayout.WEST);
		southOfNothPanel.add(flowPanelForRadioButtons, BorderLayout.EAST);

		// add the JPanal to the north panel that will compose all of the north side of
		// the Calculator
		north.add(southOfNothPanel, BorderLayout.SOUTH);

		// create the C JButton with specified parameters
		JButton cButton = createButton("c", "C", Color.black, Color.red, true, controller);
		cButton.setFont(new Font("defualt", Font.BOLD, 17));
		cButton.setOpaque(true);
		cButton.setBorder(new MatteBorder(8, 0, 0, 0, Color.black));
		cButton.setPreferredSize(new Dimension(55, 55));

		// create the equals button for the calculator with specified parameters
		JButton equals = createButton("=", "=", Color.black, Color.yellow, true, controller);
		equals.setFont(new Font("defualt", Font.BOLD, 17));
		equals.setBorder(new MatteBorder(8, 0, 0, 0, Color.black));
		equals.setOpaque(true);
		equals.setPreferredSize(new Dimension(55, 55));

		// Create a JPannal to contain the 4 arithmetic operators that will go on north
		// of middle panel
		JPanel topFourRadioButtons = new JPanel();
		topFourRadioButtons.setBackground(Color.BLACK);

		topFourRadioButtons.setBorder(new MatteBorder(5, 0, 0, 0, Color.black));
		GridLayout layout = new GridLayout();// make it grid layout
		layout.setHgap(4);

		topFourRadioButtons.setLayout(layout);// set the layout of panel to grid layout

		// make 4 JButtons for the arithmetic operators of specified values
		JButton plus = createButton("+", "+", Color.black, Color.cyan, true, controller);
		JButton minus = createButton("-", "-", Color.black, Color.cyan, true, controller);
		JButton multiply = createButton("*", "*", Color.black, Color.cyan, true, controller);
		JButton divide = createButton("/", "/", Color.black, Color.cyan, true, controller);

		// add JButtons to the JPanel for north side of middle panel
		topFourRadioButtons.add(plus);
		topFourRadioButtons.add(minus);
		topFourRadioButtons.add(multiply);
		topFourRadioButtons.add(divide);

		// Panel to contain bottom 4 JButtons for arithmetic operators
		JPanel bottomFourBottomRadioButtons = new JPanel();
		bottomFourBottomRadioButtons.setBackground(Color.BLACK);

		GridLayout layout1 = new GridLayout();// set its layout to grid layout
		layout1.setHgap(4);// set the gap between the buttons

		bottomFourBottomRadioButtons.setLayout(layout1);// apply the layout to panel

		// make 4 JButtons for arithmetic operators of specified values
		JButton multiplyV2 = createButton("*", "*", Color.black, Color.cyan, true, controller);
		JButton divideV2 = createButton("/", "/", Color.black, Color.cyan, true, controller);
		JButton plusV2 = createButton("+", "+", Color.black, Color.cyan, true, controller);
		JButton minusV2 = createButton("-", "-", Color.black, Color.cyan, true, controller);

		// add arithmetic Buttons to the Bottom Panel of the Calculator
		bottomFourBottomRadioButtons.add(multiplyV2);
		bottomFourBottomRadioButtons.add(divideV2);
		bottomFourBottomRadioButtons.add(plusV2);
		bottomFourBottomRadioButtons.add(minusV2);

		// Make Panel to contain the Hex Letters and the Numbers for center of
		// Calculator
		JPanel middleHolder = new JPanel(new BorderLayout());

		// Add the 4 arithmetic operators to the top and south of the middle panel for
		// center main panel
		middleHolder.add(topFourRadioButtons, BorderLayout.NORTH);
		middleHolder.add(bottomFourBottomRadioButtons, BorderLayout.SOUTH);

		/* add text fields to text panel */
		textPanel.add(display1, BorderLayout.CENTER);
		textPanel.add(display2, BorderLayout.NORTH);

		// add text field panel to north panel in center
		north.add(textPanel, BorderLayout.CENTER);

		/* add buttons JLabels to north panel */
		north.add(dotButton, BorderLayout.EAST);
		north.add(error, BorderLayout.WEST);

		// make JPanel for middle holder of the main center frame
		JPanel middleHolderBorder = new JPanel();

		GridLayout gridSixByThree = new GridLayout(6, 3);// make its layout grid for all the buttons

		/* 3 pixel gap between keypad buttons */
		gridSixByThree.setHgap(3);
		gridSixByThree.setVgap(3);

		middleHolderBorder.setBorder(new MatteBorder(2, 2, 2, 2, Color.white));

		middleHolderBorder.setLayout(gridSixByThree);// set middle panel to the layout specified by grid layout

		for (int i = 0; i < 18; i++) {// for loop runs 18 times to add various letters and numbers to center of
										// calculator

			if (i < 6) {// disable hex letters at launch of application then make hex buttons
				hexButtons[i] = createButton(holder[i], holder[i], Color.black, Color.blue, false, controller);
			}

			else if (i == 15 || i == 17) {// Make Number buttons for center of Calculator
				hexButtons[i] = createButton(holder[i], holder[i], Color.black, Color.MAGENTA, true, controller);
			}

			else {// for the 2 pink buttons of the arithmetic type

				hexButtons[i] = createButton(holder[i], holder[i], Color.black, Color.blue, true, controller);

			}

			middleHolderBorder.add(hexButtons[i]);// add the hex buttons to the panel

		}

		middleHolder.add(middleHolderBorder);// add the grid layout panel to the center of main center panel

		/* add panels to the main panel for Calculator */
		add(north, BorderLayout.NORTH);
		add(cButton, BorderLayout.WEST);
		add(equals, BorderLayout.EAST);
		add(middleHolder, BorderLayout.CENTER);

	}

	/**
	 * The purpose of this method is to set the parameters of the JButton to what
	 * was passed to the method constructor
	 * 
	 * @param text    This is the text that will be displayed for button
	 * @param ac      Action command for button
	 * @param fg      text color for button
	 * @param bg      background color for button
	 * @param enable  if button is enabled
	 * @param handler event handler for button
	 * @return b object containing JButton created
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, boolean enable, ActionListener handler) {

		JButton b = new JButton(text);// make button

		b.setForeground(fg);// sets the color of the text letters
		b.setBackground(bg);// set the background color of the button

		if (ac != null) {// if ac is not null put in action command
			b.addActionListener(handler);
		}

		dotButton.setFont(new Font("default", Font.PLAIN, 17));// default font with size 17

		if (enable == false) {// if enabled is false button will be disabled
			b.setEnabled(false);
		} // otherwise it will not be

		return b;
	}

	/**
	 * Purpose of this class is to implement an ActionListener whenever a button is
	 * pressed Within the Calculator program
	 * 
	 * @author Jonathan Slaunwhite
	 * @version 1.0
	 * @see Controller.java
	 * @since 1.8
	 */
	private class Controller implements ActionListener {

		CalculatorModel cm = new CalculatorModel();// object of CalculatorModel model class

		/**
		 * This method is the ActionListener which changes the display of the text field
		 * to whatever button was pressed
		 * 
		 * @param arg0 event handler
		 */
		@Override
		public void actionPerformed(ActionEvent arg0) {

			switch (arg0.getActionCommand()) {// get action command for button pressed

			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case "A":
			case "B":
			case "C":
			case "D":
			case "E":
			case "F":
			case ".":

				dotButton.setEnabled(true);

				if (display1.getText().equals("0.0") || display1.getText().equals(".0")
						|| display1.getText().equals("0")) {// if default precision is showing delete it and put in
															// number
					display1.setText(arg0.getActionCommand());
				}

				else {// concat number with original text
					display1.setText(display1.getText().concat(arg0.getActionCommand()));

				}
				break;

			case "+":
			case "-":
			case "*":
			case "/":

				/*If user wants to put in 2+- then it will remove then + and add in the minus*/
				if(display2.getText().contains("+")||display2.getText().contains("-")||display2.getText().contains("*")||display2.getText().contains("/")) {
					
					display1.setText(display2.getText().substring(0,display2.getText().length()-1));
			
				}
	
				display2.setText(display1.getText().concat(arg0.getActionCommand()));// set display2 to display1 plus
				display1.setText("");// clear display1
				cm.setArithmeticOperation(arg0.getActionCommand());// set arithmatic operation in calc class
				
				
				
	
				
				
				break;

			case "\u00B1": // plus or minus

				if (display1.getText().charAt(0) != '-') {// if minus sign is not in display1 put it in beginning of
															// text
					display1.setText("-".concat(display1.getText()));
				} else {// if there is a minus sign remove it

					display1.setText(display1.getText().substring(1)); // remove minus sign
				}

				break;

			case "HEX":

				middleButtonEnabler(true);// enable hex buttons, disable .
				cm.operationalMode("HEX");
				cm.floatingPointPrecision("HEX");

				switch (cm.getFloatingPointPrecision()) {
				case "HEX":
					display1.setText("0");
					break;// set text to selected fields
				default:
					display1.setText("0.0");
					break;
				}

				break;

			case ".0":

				middleButtonEnabler(false);// disable hex buttons enable .
				cm.operationalMode(".0");
				cm.floatingPointPrecision(".0");

				switch (cm.getFloatingPointPrecision()) {
				case "HEX":
					display1.setText("0");
					break;
				default:
					display1.setText("0.0");
					break;
				}

				break;
			case ".00":

				middleButtonEnabler(false);// disable hex buttons enable .
				cm.operationalMode(".00");
				cm.floatingPointPrecision(".00");

				switch (cm.getFloatingPointPrecision()) {
				case "HEX":
					display1.setText("0");
					break;
				default:
					display1.setText("0.0");
					break;
				}

				break;
			case "Sci":

				middleButtonEnabler(false);// disable hex buttons enable .

				cm.operationalMode("Sci");
				cm.floatingPointPrecision("Sci");

				switch (cm.getFloatingPointPrecision()) {
				case "HEX":
					display1.setText("0");
					break;
				default:
					display1.setText("0.0");
					break;
				}

				break;

			case "c":// clear the displays

				switch (cm.getFloatingPointPrecision()) {
				case "HEX":
					display1.setText("0");
					break;
				default:
					display1.setText("0.0");
					break;
				}

				display2.setText("");
				break;

			case "\u27f8":// backspace arrow

				// no error from deleting from no numbers from try catch
				try {// delete last entered value from dispaly1

					String bob = display1.getText();
					bob = bob.substring(0, bob.length() - 1);// delete the last character in string value
					display1.setText(bob);// display the contents

					if (display1.getText().equals("-")) {

						switch (cm.getFloatingPointPrecision()) {// if backspace button pressed when only minus is
																	// present in display set display to default
																	// precision

						case ".0":
							display1.setText("0");
							break;
						case ".00":
							display1.setText("0.0");
							break;
						case "Sci":
							display1.setText("0.0");
							break;
						case "HEX":
							display1.setText("0");
							break;

						}

					}

				} catch (Exception e) {

				}
				break;

			case "=":

				try {// try catch to not allow program to crash or display error messages to console

					String temp = display2.getText();
					temp = temp.substring(0, temp.length() - 1);// take display 2 but take away operational arthmatic
																// operator

					cm.setOperands1(temp);// give peratmeter of display 1 to operanainal mode 1
					cm.setOperands2(display1.getText());// set perameter of operanaal mode 2 to display 2

					display2.setText("");// empty text field 2
					dotButton.setEnabled(false);// backspace button not press able

					display1.setText(cm.getResult());

				} catch (Exception e) {// do not print out any errors proceed as normal
					// System.out.print("I stop all errors");
				}

				break;

			}// end of switch

		}

		/*
		 * this method makes calling the same code over and over again take up less
		 * space From switch statements .0 .00 Sci and Hex
		 */

		/**
		 * The purpose of this method is to repeat common operations that must occur
		 * such as enabling or disabling hex buttons
		 * 
		 * @param passer boolean value used to determine if hex buttons are disabled or
		 *               enabled
		 */
		private void middleButtonEnabler(Boolean passer) {// disable or enable hex buttons and . buttons

			if (passer == true) {// Hex button pressed
				for (int i = 0; i < 6; i++) {
					hexButtons[i].setEnabled(true);
				}

				hexButtons[15].setEnabled(false);// disable dot operator

				cm.floatingPointPrecision("HEX");// set operational mode to hex
				cm.operationalMode("HEX");

				error.setBackground(Color.GREEN);
				error.setText("H");

			} else if (passer == false) {// .0 .00 Sci buttons pressed
				for (int i = 0; i < 6; i++) {
					hexButtons[i].setEnabled(false);
				}
				hexButtons[15].setEnabled(true);// enable dot operator

				cm.floatingPointPrecision("HEX");// set operational mode to hex
				cm.operationalMode("HEX");

				error.setBackground(Color.yellow);
				error.setText("F");

			}

		}// end of code short method

	}// end of class

}// end of main class
