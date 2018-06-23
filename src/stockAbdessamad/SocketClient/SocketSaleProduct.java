/**
 * 
 */
package stockAbdessamad.SocketClient;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import clientSocket.AbstractClientSocket;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author aramil
 *
 */

public class SocketSaleProduct extends AbstractClientSocket{

	/**
	 * 
	 */
	public SocketSaleProduct() {
		// TODO Auto-generated constructor stub
	}
	
	    /**
	     * 
	     * @param magasinName
	     * @param idProduct
	     * @param quantity
	     */
	    public void updateStock(String magasinName, int idProduct, int quantity){
	        try {
	        	
	            GsonBuilder builder = new GsonBuilder();
	            Gson gson = builder.create();
	            Map data = new HashMap();
	            data.put("magasinName", magasinName);
	            data.put("idProduct", idProduct);
	            data.put("quantity", quantity);
	            String dataToSend = gson.toJson(data);
	            System.out.println("Socket connection...");
	            
	            //To test in local machine please uncomment the line below:
	            //Socket s = new Socket("127.0.0.1", 5000);
	            Socket s = new Socket(InetAddress.getLocalHost(), 5000);
	            System.out.println("the client"+InetAddress.getLocalHost()+ "is listening on port" + 5000);
	            PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
	            System.out.println("Print after");
	            BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());
	            //We inform the server that we want to update the stockTable in database after selling
	            String messageToServer = "PRODUCT";
	            w1.write(messageToServer);
	            w1.flush();
	            //we wait for server's response
	            String reponse = read(b2);
	            System.out.println(reponse);
	            //Now we send to server the JSON file, with the data to insert
	            w1.write(dataToSend);
	            w1.flush();
	            //we read the response from the server
	            String messageFromServer = read(b2);
	            System.out.println("Message du serveur:" + messageFromServer);

	            System.out.println(messageFromServer);
	            messageFromServer = read(b2);
	            JFrame fenResp = new JFrame();
	            JPanel containerResp = new JPanel();
	            fenResp.setSize(600, 300);
	            fenResp.setLocationRelativeTo(null);
	            JLabel jlabResp = new JLabel(messageFromServer);
	            containerResp.add(jlabResp, BorderLayout.CENTER);
	            fenResp.setContentPane(containerResp);
	            fenResp.setVisible(true);
	            
	            
	            s.close();
	           

	        }catch (Exception e) {
	        	e.printStackTrace();
			}
	}

}
