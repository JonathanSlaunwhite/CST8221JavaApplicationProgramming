
/*
File name: 			CalculatorSplashScreen
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		1 part 2
Date:			    2020-03-06
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class it to Create and display a splash screen 
					with author name and student number that lasts for 5 seconds.
*/

package Calculator;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

/**
 * Purpose of this class it to Create and display a splash screen with author
 * name and student number that lasts for 5 seconds.
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see CalculatorSplashScreen.java
 * @since 1.8
 */
public class CalculatorSplashScreen extends JPanel {

	/**
	 * Time that is used to display splash screen for
	 */
	int time;

	/**
	 * JFrame variable used to create the JFrame
	 */
	JFrame f;
	/**
	 * JLabel for the picture for splash screen and info display for the frame
	 */
	JLabel picture, info;

	/**
	 * Purpose of this method is to set the time variable to what it was set in in
	 * the Calculator class
	 * 
	 * @param time used to have splash screen displayed for certain amount of time
	 */
	public CalculatorSplashScreen(int time) {// get time set from calculator class
		this.time = time;
	}

	/**
	 * Purpose of this method is to create a frame and then display a splash screen
	 * and student name and number on the JFrame. Then close splash screen after 5
	 * seconds
	 * 
	 */
	public void showSplashWindow() {

		JProgressBar bar = new JProgressBar();// make a Jprogressbar

		bar.setStringPainted(true);// show text in bar
		bar.setString("Please wait...Loading Calculator");// put string contents in bar

		f = new JFrame();// make a frame

		/* make a JLabel with a picture imported into it */
		JLabel picture = new JLabel(new ImageIcon("11111.jpg"));

		info = new JLabel("Jonathan Slaunwhite  # 040939090");// make JLabel with name and student number

		JPanel p = new JPanel(new BorderLayout());// make main panel border layout

		p.add(bar, BorderLayout.NORTH);// add progress bar to north of jPannel
		p.add(picture, BorderLayout.CENTER);// add picture to center of jPannal
		p.add(info, BorderLayout.SOUTH);// add student information to south panel

		f.add(p);// add panel to frame

		// set the size of frame
		f.setSize(340, 500);

		f.setLocationRelativeTo(null);// set its location relative to middle

		f.show(true);// show frame

		/* make program wait for 5 seconds then resume program. */
		try {

			for (int i = 0; i < 100; i++) {// loop will run 100 times

				bar.setValue(i);// set bar value to i in for loop
				/*
				 * divide by 100 because loop runs 100 times. therefore thread will sleep for
				 * total of 5 seconds
				 */
				Thread.sleep(time / 100);// make thread sleep for the time set in calculator class- 5 seconds.

			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		f.show(false);// frame will no longer show

	}

}
