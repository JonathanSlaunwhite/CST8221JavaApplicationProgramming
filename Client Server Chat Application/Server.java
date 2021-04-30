
/*
File name: 			Server
Author:				Jonathan Slaunwhite
Course &section: 	CST8221 , 303
Assignment: 		2 part 1
Date:			    2020-03-02
Professor: 			Daniel Cormier
Purpose: 			Purpose of this class is to call the main method to run the 
					frame and call class to set the JPanel

*/

import java.awt.EventQueue;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

/**
 * Purpose of this class is to Purpose of this class is to call the main method
 * to run the frame and call class to set the JPanel
 * 
 * @author Jonathan Slaunwhite
 * @version 1.0
 * @see Server.java
 * @since 1.8
 */
public class Server {

	
	static String title;
	static Socket socket;
	
	
	/**
	 * Purpose of this method is the main method to run server chat program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int port;// port number

		ServerSocket server = null;//server socket

		if (args.length > 0) {// number of command line arguments greater then 0 or none

			port = Integer.parseInt(args[0]);// get port number from command line

			System.out.print("Port: " + port + " being used ");

		} else {// if no arguments passses use default port

			port = 65535;// default port

			System.out.print("The defualt port is being used");
		}

		try {// creates a TCP/IP server socket bound to the specified port.

			server = new ServerSocket(port);

		} catch (Exception e) {
			System.out.print("Error");
		}

		int friend = 0;// local variable friend and initializes it to 0

		while (true) {// endless loop

			try {

				 socket = server.accept();

				if (socket != null) {//if socket is not null 

					if (socket.getSoLinger() != -1) {
						socket.setSoLinger(true, 5);
					}

					if (!socket.getTcpNoDelay()) {
						socket.setTcpNoDelay(true);
					}

					friend++;// increment friend variable

					// change me 123123123 123131312312312313123123erjne;oign;eroingo;ign
					System.out.printf("Connected to client socket: Socket - addr: %s port: %d localport: %d\n",
							socket.getInetAddress(), socket.getPort(), socket.getLocalPort());

					 title = "YourName's Friend " + friend;// title

					
				
					
					
					launchClient(socket,title);// call lanch client with null argunets
				
					
					
					
				} // if not null end
			} catch (Exception e) {
				System.out.print("Error");
			}
			
			//launchClient(null,"YEET");// call lanch client with null argunets

			break;
		}

		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				launchClient(null, "jonathan slaunwhite");// call lanch client with null argunets

			}
		});

	}// end of main method

	/**
	 * Purpose of this method is to set properties for the frame and call serverchat
	 * class
	 * 
	 * @param socket socket paremeter
	 * @param title  title for program
	 */
	public static void launchClient(Socket socket, String title) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ServerChatUI c = new ServerChatUI(null);// call class with null paremter passing through

				c.setTitle(title);// set title

				c.setLocationRelativeTo(null); // will center screen

				c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// when click x JFrame will exit

				c.setVisible(true);// make frame visible

			}
		});

	}

}
