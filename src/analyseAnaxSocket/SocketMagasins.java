package analyseAnaxSocket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import analyseAnax.Magasins;
import clientSocket.AbstractClientSocket;

/**
 * @author Anaximandro
 * @version 1.0
 * This magasins socket class is used to return magasins datas
 */

public class SocketMagasins extends AbstractClientSocket {

	public Magasins getMagasin(int idMagasin) {
		try {
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			Socket s = new Socket(InetAddress.getLocalHost(), 5000);
			PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
			BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());
			// We inform the server that we want to find data in database
			String demand = "FINDMAGASIN";
			w1.write(demand);
			w1.flush();
			// we wait for server's response
			String reponse = read(b2);
			System.out.println(reponse);
			// Now we send to server the JSON file, with the data to insert
			w1.write(String.valueOf(idMagasin));
			w1.flush();
			// we read the response from the server
			String retourServer = read(b2);
			System.out.println("retour du serveur:" + retourServer);
			Magasins mag = gson.fromJson(retourServer, Magasins.class);
			s.close();
			return mag;

		} catch (IOException e) {
			return null;
		}
	}
}
