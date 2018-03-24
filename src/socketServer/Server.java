package socketServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Server{  
	public static void main(String args[])throws Exception{   
		//Initiation de la socket sur le port 5000
		Socket s;
		ServerSocket serv;
		try {
			serv = new ServerSocket(5000);
			s = serv.accept();
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			FileOutputStream fout = new FileOutputStream(new File("Client_received.json"));
			byte buf[] = new byte[1024];
			int n;
			while ((n = in.read(buf)) != -1) {
				fout.write(buf, 0, n);
			}
			fout.close();
			s.close();
		} catch (Exception e) {}
	}
		TS js = new TS("Client_received.json");
		ClientDAO cl = js.toto();
}