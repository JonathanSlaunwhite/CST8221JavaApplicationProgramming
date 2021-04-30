import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ChatRunnable<T extends JFrame & Accessible> implements Runnable {

	private final T ui;
	private final Socket socket;
	private final ObjectInputStream inputStream;
	private final ObjectOutputStream outputStream;
	private final JTextArea display;

	ChatRunnable(T ui, ConnectionWrapper connection) {

		this.ui = ui;
		this.inputStream = connection.getInputStream();
		this.outputStream = connection.getOutputStream();

		this.socket = connection.getSocket();
		this.display = ui.getDisplay();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		String strin="";
		LocalDateTime time = LocalDateTime.now();//get the local date right now
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd, HH:mm a");//format the date

		while (true) {// endless loop

			if (socket.isClosed()) {// if socket is closed break the loop
				break;
			}
			

			
			
			try {
				strin = (String) inputStream.readObject();
				
				if(strin.trim().equals(ChatProtocolConstants.CHAT_TERMINATOR)) {
					
					final String terminate = ChatProtocolConstants.DISPLACMENT+time.format(formatter)+ChatProtocolConstants.LINE_TERMINATOR+strin;
				
				
					display.append(terminate);
					break;
				
				}
				

			} catch (Exception e) {
				
				System.out.print("Error");
				break;
				//e.printStackTrace();
			}

			
			final String append = ChatProtocolConstants.DISPLACMENT + time.format(formatter) 
			+ ChatProtocolConstants.LINE_TERMINATOR + strin;
		
			
			display.append(append);
			
			
			
			if(!socket.isClosed()) {
				
				
				String string = ChatProtocolConstants.DISPLACMENT + ChatProtocolConstants.CHAT_TERMINATOR 
						+ ChatProtocolConstants.LINE_TERMINATOR;
				
				
				try {
					outputStream.writeObject(string);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
			}
			
			
			
		}//end of loop

		ui.closeChat();//close chat called before return
		
	}

}
