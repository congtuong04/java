package Client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private Socket s;
	private BufferedReader bfr;
	private BufferedWriter bfw;
	public Client(Socket socket) {

			try {
				this.s=socket;
				this.bfw= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				this.bfr= new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public void Dangki(String username,String email,int phone,String password) {
		try {
			bfw.write(username);
			bfw.newLine();
			bfw.flush();
			
			bfw.write(email);
			bfw.newLine();
			bfw.flush();
			
			bfw.write(phone);
			bfw.newLine();
			bfw.flush();
			
			bfw.write(password);
			bfw.newLine();
			bfw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnect(s, bfr, bfw);
		}
	}
	public void Dangnhap(String username,String password) {
		try {
			bfw.write(username);
			bfw.newLine();
			bfw.flush();
			bfw.write(password);
			bfw.newLine();
			bfw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			closeConnect(s, bfr, bfw);
		}
	}
	public void closeConnect(Socket s, BufferedReader bfr, BufferedWriter bfw) {
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
	public void SendMessages(String messages) {
		
	}
	public String ListenMessages() {
		
		return null;
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Socket s= new Socket("localhost",1111);
//		Client client= new Client(s);
//	}
//	public void StartClient()  {
//			try {
//				Socket s= new Socket("localhost",1234);
//				Client client= new Client(s);
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	}
}
