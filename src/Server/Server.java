package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	private ServerSocket ss;
	public Server(ServerSocket ss) {
		this.ss= ss;
	}
	public void startServer() throws IOException {
		while(!ss.isClosed()) {
			Socket s=ss.accept();
			System.out.println("New Client conected");
			ClientHandler clienthandler= new ClientHandler(s);
			Thread thread= new Thread(clienthandler);
			thread.start();
			
		}
	}
	public void closeServer() throws IOException {
		if(ss==null) {
			ss.close();
		}
	}
	public static void main(String[] args) {
		try {
			ServerSocket ss= new ServerSocket(1234);
			Server se= new Server(ss);
					se.startServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
