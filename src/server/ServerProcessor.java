package server;

import com.google.gson.Gson;
import connexion.PoolDeConnexion;
import dao.*;
import pojo.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ilies, axel, aramil, Anaximandro
 * @version 1.2
 * Class with all the Server sockets and operation with database
 */
public class ServerProcessor implements Runnable {

	private Socket sock;
	private PrintWriter writer = null;
	private BufferedInputStream reader=null;
	private PoolDeConnexion connection;

	public ServerProcessor(Socket s, PoolDeConnexion connection){
		this.connection = connection;
		this.sock=s;

	}

	/**
	 * public method with all the kind of call from the client to server
	 */
	public void run() {
		boolean closeConnexion = false;
		while(!sock.isClosed()){
			try{
				writer = new PrintWriter(sock.getOutputStream());
				reader = new BufferedInputStream(sock.getInputStream());
				Gson gson = new Gson();
				//first interaction with the client, sending the kind of action
				String demand = read();
				switch(demand.toUpperCase()){
				case "AJOUTEMPLACEMENT":
					//Server understands the action asked, he returns "OK"
					String toSend = "OK for insert";
					//the Server waits for the data
					writer.write(toSend);
					writer.flush();
					//the server read the data
					String request = read();
					Emplacements e1 = gson.fromJson(request, Emplacements.class);
					EmplacementsDAO daoInsert = new EmplacementsDAO(connection.getConnection());
					Emplacements eCheck = daoInsert.find(e1.getIdEmplacement());
					if(eCheck == null)
					{
						daoInsert.create(e1);
						Emplacements e2 = daoInsert.find(e1.getIdEmplacement());
						String reponseServ = "Nouvel emplacement numéro" + e1.getIdEmplacement()+ " bien ajouté au référentiel, merci !";
						writer.write(reponseServ);
						writer.flush();

					}
					else
					{
						String reponseServ = "Impossible de créer l'objet en question, l'idEmplacement "+ e1.getIdEmplacement() +" est déjà utilisé par un emplacement";
						writer.write(reponseServ);
						writer.flush();
					}
					connection.releaseConnection(connection.getListUsed().get(connection.getListUsed().size()-1));
					break;

				case "DELETEEMPLACEMENT":
					//Server understands the action asked, he returns "OK"
					String toSendDelete = "OK for insert";
					//the Server waits for the data
					writer.write(toSendDelete);
					writer.flush();
					//the server read the data
					String requestDelete = read();
					Emplacements eDelete = gson.fromJson(requestDelete, Emplacements.class);
					EmplacementsDAO daoDelete = new EmplacementsDAO(connection.getConnection());
					System.out.println("nbr id: "+ eDelete.getIdEmplacement());
					if(daoDelete.find(eDelete.getIdEmplacement())== null){
						String reponseServ = "Impossible de supprimer, emplacement inexistant";
						writer.write(reponseServ);
						writer.flush();
					}
					else {
						daoDelete.delete(eDelete);
						String reponseServ =" Emplacement n°"+eDelete.getIdEmplacement() +" bien supprimé !";
						writer.write(reponseServ);
						writer.flush();

					}
					connection.releaseConnection(connection.getListUsed().get(connection.getListUsed().size()-1));
					break;
				case "FINDEMPLACEMENT":
					//Server understands the action asked, he returns "OK"
					String toSend2 = "OK for find";
					//the Server waits for the data
					writer.write(toSend2);
					writer.flush();
					//the server read the data
					String toFind = read();
					System.out.println("donnée reçu sur le server: "+toFind);
					Emplacements e2 = gson.fromJson(toFind, Emplacements.class);
					System.out.println("donnée converti en int: "+ e2.getIdEmplacement());
					EmplacementsDAO daoFind = new EmplacementsDAO(connection.getConnection());
					Emplacements eFind =daoFind.find(e2.getIdEmplacement());
					String jsonFind = gson.toJson(eFind);
					//the server looks and find (or not) the data asked and return his answer to the client
					if(jsonFind == null){
						String failFind = "";
						writer.write(failFind);
						writer.flush();

					}else {
						writer.write(jsonFind);
						writer.flush();

					}
					connection.releaseConnection(connection.getListUsed().get(connection.getListUsed().size()-1));
					break;
				case "PROFILCLIENT":
					//Server understands the action asked, he returns "OK"
					String toSend3 = "OK for find client";
					//the Server waits for the data
					writer.write(toSend3);
					writer.flush();
					//the server read the data
					String checkIdentification = read();
					Identification identification = gson.fromJson(checkIdentification, Identification.class);
					ClientDAO clientDAO = new ClientDAO(connection.getConnection());
					Client c = clientDAO.ConnectionClient( identification.getPseudo(), identification.getPassword());
					if(c == null){
						System.out.println("Client not found");
						String failFind = "Fail";
						String jsonFindClient = gson.toJson(c);
						writer.write(jsonFindClient);
						writer.flush();
						System.out.println("error send to client");
					}else{
						String jsonFindClient = gson.toJson(c);
						writer.write(jsonFindClient);
						writer.flush();
					}
					connection.releaseConnection(connection.getListUsed().get(connection.getListUsed().size()-1));
					break;
				case "PROFILAGE":
					//Server understands the action asked, he returns "OK"
					String toSend4 = "OK for find client";
					//the Server waits for the data
					writer.write(toSend4);
					writer.flush();
					//the server read the data
					String simpleId = read();
					SimpleId id = gson.fromJson(simpleId, SimpleId.class);
					Connection cClient = connection.getConnection();
					ClientDAO clientDAO2 = new ClientDAO(cClient);
					Client c2 = clientDAO2.find( id.getId());
					String answer;
					//let's compare this keyword list to type profile keyword list, if the comparaison seems good, we link this type profile to the client
					// return "OK" if not issue during the processus
					// return "Failure" if issue
					if(c2 == null){
						System.out.println("Client not found");
						String failFind = "NOEXIST";
						String jsonFindClient = gson.toJson(c2);
						writer.write(jsonFindClient);
						writer.flush();
						System.out.println("error send to client");
					}else{
						Connection cKw = connection.getConnection();
						Connection cLinkClientTP = connection.getConnection();
						Connection cLinkTPKW = connection.getConnection();
						KeyWordDAO kwd1 = new KeyWordDAO(cKw);
						LinkClientTPDAO lctpd1 = new LinkClientTPDAO(cLinkClientTP);
						LinkTPKeyWordDAO ltpkw = new LinkTPKeyWordDAO(cLinkTPKW);

						//first, let's clean the existing linked type profile to the client
						lctpd1.cleanLinkedTPForClient(id.getId());
						// Then Let's find the keyword list from client purchase history
						List<KeyWordOccurence> kwList = kwd1.getListKeyWordOccurence(id.getId());
						if( kwList.isEmpty()){
							answer = "EMPTY";
						}
						else{
							//let's keep only relevant keyword from this list
							List<String> pertinentKW = new ArrayList<String>();
							for(KeyWordOccurence kwol : kwList){
								if(kwol.getKeyWordOccurence() >3)
									pertinentKW.add(kwol.getNameKeyWord());
							}
							if(pertinentKW.isEmpty()){
								answer="NPERTINENT";
							}
							else{
								//Let's find the type profile where there is similar keyword(s)
								List<Integer> listFindedProfiles = new ArrayList<>();
								for(String kW : pertinentKW){
									List<Integer> listIdProfiles = ltpkw.getTPbyKeyword(kW);
									for(int idProfile : listIdProfiles)
										listFindedProfiles.add(idProfile);
								}
								//now we have list of id from type profiles with similitude with client purchase list
								//if an type profile id appears more than 3 times, we can link it to the client
								int compteur=0;
								List<Integer> TPtoBeLinked = new ArrayList<>();
								for(Integer i : listFindedProfiles){
									compteur=0;
									for(Integer j :listFindedProfiles){
										if(i==j){
											compteur++;
										}
									}
									if(compteur > 1){
										TPtoBeLinked.add(i);
									}
								}
								if(TPtoBeLinked.isEmpty()){
									answer="NOTPLINKED";
								}
								else{
									//we have ours TPs which have to be linked to the client
									for(Integer i: TPtoBeLinked){
										if(lctpd1.find(i) == null){
											lctpd1.create(new LinkClientTP(0,id.getId(),i));
										}
									}
									answer="SUCCESS";

								}
							}
						}
						connection.releaseConnection(cKw);
						connection.releaseConnection(cLinkClientTP);
						connection.releaseConnection(cLinkTPKW);
						connection.releaseConnection(cClient);
						writer.write(answer);
						writer.flush();
					}
					break;
					/**
					 * aramil       
					 */
				case "PRODUCT":
					//Server understands the action asked, he returns the msg below
					String messageToclient = "Selling products...Data received..Updating stock table";
					Connection connexion1 = null;
					Connection connexion2 = null;
					Connection connexion3 = null;
					try {
						connexion1 =  connection.getConnection();
						connexion2 =  connection.getConnection();
						connexion3 =  connection.getConnection();

						//the Server waits for the data
						writer.write(messageToclient);
						writer.flush();
						//the server read the data
						String CelintRequest = read();
						Map datafromClient = gson.fromJson(CelintRequest, Map.class);

						//Data processing 
						MagasinsDAO magasinDAO = new MagasinsDAO(connexion1);
						ProductDAO productDAO = new ProductDAO(connexion2);

						final Date date = new Date();
						int idProduct = (int)Double.parseDouble(datafromClient.get("idProduct").toString());
						int quantity = (int)Double.parseDouble(datafromClient.get("quantity").toString());
						String magasinName = datafromClient.get("magasinName").toString();
						Product product = productDAO.find(idProduct); 

						Magasins magasin = magasinDAO.findMagasinByName(magasinName);
						int idMagasin = magasin.getIdMagasin();

						if (magasin != null && product != null) {
							messageToclient = "Recherche du produit et du magasin associe";
							writer.write(messageToclient);
							writer.flush();
							StockDAO stockDAO = new StockDAO(connexion3);
							// Updating Stock table
							Stock stockToUpdate = stockDAO.find(idProduct, idMagasin);
							stockToUpdate.setQuantite(stockToUpdate.getQuantite() - quantity);

							String dateSortie = new SimpleDateFormat("yyyy-MM-dd").format(date);
							stockToUpdate.setDateSortie(dateSortie);
							stockDAO.update(stockToUpdate);
						}
						else {

							messageToclient = "Code barre/nom magasin erronne..Veuillez v�rifier les informations entrees!";
							writer.write(messageToclient);
							writer.flush();
						}

					} 
					finally{
						if(connexion1 != null && connexion2 != null && connexion3 != null) {
							connection.releaseConnection(connexion1);
							connection.releaseConnection(connexion2);
							connection.releaseConnection(connexion3);
							writer.write("Stock updated!");
							writer.flush();
						} 
					}
					break;
					
					/**
					 * Anaximandro
					 */
					
				case "FINDCHIFFREDAFFAIRES":
					//Server understands the action asked, he returns "OK"
					String toSendC = "OK for find";
					//the Server waits for the data
					writer.write(toSendC);
					writer.flush();
					//the server read the data
					String toFindC = read();
					System.out.println("Donn�e re�ue sur le server: "+toFindC);
					ChiffreDaffairesDAO cDaoFind = new ChiffreDaffairesDAO(connection.getConnection());
					Collection<ChiffreDaffaires> cFind = cDaoFind.find(toFindC);
					String jsonFindC = gson.toJson(cFind);
					for(ChiffreDaffaires chiffre : cFind) {
						System.out.println(chiffre.getMontant());
					}
					//the server looks and find (or not) the data asked and return his answer to the client
					if(jsonFindC == null){
						String failFind = "";
						writer.write(failFind);
						writer.flush();

					}else {
						writer.write(jsonFindC);
						writer.flush();

					}
					connection.releaseConnection(connection.getListUsed().get(connection.getListUsed().size()-1));
					break;
				}			

			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}


	/**
	 * This methods read the message from the client
	 * @return String
	 * @throws IOException
	 */
	private String read() throws IOException {
		String response ="";
		int stream;
		byte[] b = new byte[4096];
		stream = reader.read(b);
		response = new String(b, 0, stream);
		return response;
	}
}
