package Server;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
public static ArrayList<ClientHandler>clientHandler= new ArrayList<>();
private Socket s;
public BufferedReader bfr;
public BufferedWriter bfw;
public User user;
	public ClientHandler(Socket s) {
		try {
			this.s=s;
			this.bfw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
			this.bfr= new BufferedReader(new InputStreamReader(s.getInputStream()));
			String username=bfr.readLine();
			String email=bfr.readLine();
			int phone=bfr.read();
			String password=bfr.readLine();
			this.user=new User(username, email, phone, password);
//			this.ClientUsername=bfr.readLine();
			clientHandler.add(this);
			broadcastMessage("Server: new client connected: "+user.getHoten());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnect(s,bfr,bfw);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String MessageFromClient;
	
			while(s.isConnected()) {
				try {
				MessageFromClient=bfr.readLine();
				broadcastMessage(MessageFromClient);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnect(s,bfr,bfw);
			break;
		}
	}
	}
	public void broadcastMessage(String message) {
		try {
			for (ClientHandler clientHandler1 : clientHandler) {
				if(!clientHandler1.user.getHoten().equals(user.getHoten())) {
					clientHandler1.bfw.write(message);
					clientHandler1.bfw.newLine();
					clientHandler1.bfw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnect(s,bfr,bfw);
		}
	}
	public void removeClientHandler() {
		clientHandler.remove(this);
		broadcastMessage("Server: "+user.getHoten()+" exit");
	}
	public void	closeConnect(Socket s, BufferedReader bfr, BufferedWriter bfw) {
		removeClientHandler();
		try {
			if(bfr==null) {
				bfr.close();
			}
			if(s==null) {
				bfr.close();
			}
			if(bfw==null) {
				bfr.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

