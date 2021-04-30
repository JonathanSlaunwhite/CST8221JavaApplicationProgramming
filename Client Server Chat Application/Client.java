
/*
File name: 			Client
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		2 part 1
Date:			    2020-03-02
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class is to call the main method to run the 
					frame and call class to set the JPanel
*/

import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;


/**
 * Purpose of this class it to add all of the logic of the calculator and then
 * display the results to calling class
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see Client.java
 * @since 1.8
 */
public class Client {

	
	
	/**
	 * Purpose of this is the main method to run client program from main.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ClientChatUI c = new ClientChatUI("Slaunwhite ClientChatUi");

				c.setSize(588, 500);// set size to what is requested

				c.setResizable(false);// cant edit size

				c.setLocationByPlatform(true);// location set by platform

				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when click x JFrame will exit

				c.setVisible(true);// make frame visible

			}
		});

	}

}
