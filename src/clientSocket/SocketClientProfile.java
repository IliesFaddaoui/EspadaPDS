package clientSocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pojo.Client;
import pojo.Emplacements;
import pojo.Identification;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Ilies
 * @version 1.0
 * This client socket class is used to return client profile data
 */
public class SocketClientProfile extends AbstractClientSocket {
    /**
     * This methods return client profile data from the server to client when propers login/password are given
     * @param pseudo
     * @param password
     * @return Client
     */
    public Client getClientInformation(String pseudo, String password){
        try {
            Identification identification = new Identification(pseudo,password);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String jsonIdentification = gson.toJson(identification);
            Socket s = new Socket(InetAddress.getLocalHost(), 5000);
            PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
            BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());
            //We inform the server that we want to find data in database
            String demand = "PROFILCLIENT";
            w1.write(demand);
            w1.flush();
            //we wait for server's response
            String reponse = read(b2);
            System.out.println(reponse);
            //Now we send to server the JSON file, with the data to insert
            w1.write(jsonIdentification);
            w1.flush();
            //we read the response from the server
            String retourServer = read(b2);
            System.out.println("retour du serveur:" + retourServer);
            JFrame fenResp = new JFrame();
            Client clientResponded = gson.fromJson(retourServer, Client.class);
            s.close();
            return clientResponded;

        }catch (IOException e){ return null;}
    }
}
