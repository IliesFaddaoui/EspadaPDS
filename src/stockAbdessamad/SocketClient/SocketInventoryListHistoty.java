/**
 * 
 */
package stockAbdessamad.SocketClient;

import java.lang.reflect.Type;
import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import clientSocket.AbstractClientSocket;
import pojo.Stock;

/**
 * @author aramil
 *
 */
public class SocketInventoryListHistoty extends AbstractClientSocket{

	/**
	 * 
	 */
	public SocketInventoryListHistoty() {
		// TODO Auto-generated constructor stub
	}


	public List <Stock> DisplayStock(){
		try {

			Gson gson = new GsonBuilder().setLenient().create();
			System.out.println("Socket connection...");

			//To test in local machine please uncomment the line below:
			//Socket s = new Socket("127.0.0.1", 5000);
			Socket s = new Socket(InetAddress.getLocalHost(), 5000);
			System.out.println("the client"+InetAddress.getLocalHost()+ "is listening on port" + 5000);

			PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);            
			BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());

			//We inform the server that we want to display the stock table
			String messageToServer = "STOCKHISTORY";
			w1.write(messageToServer);
			w1.flush();
			//we wait for server's response: Stock List
			String reponse = read(b2);
			System.out.println("La list du stock retournée par le serveur"+reponse);
			reponse = read(b2);
			//Getting Data from server and converting it from Json to List    
			Type listType = new TypeToken<List>() {}.getType();
			List readFromJson = gson.fromJson(reponse, listType);
			List <Stock> listToSend = new ArrayList<Stock>();
			readFromJson.forEach(item->{
				Map data = new HashMap();
				data = (Map) item;
				System.out.println("Getting Stock data!"+data);
				int idMagasin = (int)Double.parseDouble(data.get("idMagasin").toString());
				int idProduct = (int)Double.parseDouble(data.get("idProduct").toString());
				int quantite = (int)Double.parseDouble(data.get("Quantite").toString());

				String dateEntree = data.get("dateEntree").toString();
				String dateSortie = data.get("dateSortie").toString();
				String motifEntree = data.get("motifEntree").toString();

				Stock stock = new Stock(idMagasin, idProduct, quantite, dateEntree, dateSortie, motifEntree);

				listToSend.add(stock);});


			System.out.println("The -Stock- tbale contains "+listToSend.size() + " items ");

			System.out.println("Lissste de stcok typet!!!"+ listToSend.get(1).getClass());
			String messageFromServer = read(b2);
			JFrame fenResp = new JFrame();
			JPanel containerResp = new JPanel();
			fenResp.setSize(600, 300);
			fenResp.setLocationRelativeTo(null);
			JLabel jlabResp = new JLabel(messageFromServer);
			containerResp.add(jlabResp, BorderLayout.CENTER);
			fenResp.setContentPane(containerResp);
			fenResp.setVisible(true);
			s.close();
			return listToSend;


		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
