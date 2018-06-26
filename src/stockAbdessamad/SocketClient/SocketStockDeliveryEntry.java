/**
 * 
 */
package stockAbdessamad.SocketClient;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import clientSocket.AbstractClientSocket;

/**
 * @author aramil
 *
 */
public class SocketStockDeliveryEntry extends AbstractClientSocket{

	/**
	 * 
	 */
	public SocketStockDeliveryEntry() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void updateStock(int numeroBonToSearch){
       try {
      	
           GsonBuilder builder = new GsonBuilder();
           Gson gson = builder.create();
           String dataToSend = gson.toJson(numeroBonToSearch);
            System.out.println("Socket connection...");
            
            //To test in local machine please uncomment the line below:
            Socket s = new Socket("127.0.0.1", 5000);
            //Socket s = new Socket(InetAddress.getLocalHost(), 5000);
            System.out.println("the client"+InetAddress.getLocalHost()+ "is listening on port" + 5000);
            PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
            System.out.println("Print after");
            BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());
            //We inform the server that we want to update the stockTable in database after selling
            String messageToServer = "DELIVERY";
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
