import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ConnectionWrapper {

	ObjectOutputStream outputStream;
	ObjectInputStream inputStream;
	Socket socket;

	ConnectionWrapper(Socket socket) {

		this.socket = socket;

	}

	public Socket getSocket() {

		return socket;
	}

	public ObjectOutputStream getOutputStream() {

		return outputStream;
	}

	public ObjectInputStream getInputStream() {

		return inputStream;
	}

	ObjectInputStream createObjectIStreams() throws IOException {

		inputStream = new ObjectInputStream(socket.getInputStream());
		return inputStream;

	}

	ObjectOutputStream createObjectOStreams() throws IOException {

		outputStream = new ObjectOutputStream(socket.getOutputStream());

		return outputStream;
	}

	void createStreams() throws IOException {

		outputStream = createObjectOStreams();
		inputStream = createObjectIStreams();
	}

	public void closeConnection() throws IOException {

		if (socket != null || !socket.isClosed()) {
			socket.close();
		}

		if (outputStream != null) {
			outputStream.close();
		}

		if (inputStream != null) {
			inputStream.close();
		}

	}

}
