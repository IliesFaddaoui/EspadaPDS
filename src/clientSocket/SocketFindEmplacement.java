package clientSocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pojo.Emplacements;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
/**
 * @author Ilies
 * @version 2.0
 * This client socket is used to find a existing Emplacement row on the database, through json model.
 */
public class SocketFindEmplacement extends AbstractClientSocket{
    public SocketFindEmplacement(Emplacements e1){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String data = gson.toJson(e1);
        try {
            Socket s = new Socket(InetAddress.getLocalHost(), 5000);
            PrintWriter w1 = new PrintWriter(s.getOutputStream(), true);
            BufferedInputStream b2 = new BufferedInputStream(s.getInputStream());
            //We inform the server that we want to find data in database
            String demand = "FIND";
            w1.write(demand);
            w1.flush();
            //we wait for server's response
            String reponse = read(b2);
            System.out.println(reponse);
            //Now we send to server the JSON file, with the data to insert
            w1.write(data);
            w1.flush();
            //we read the response from the server
            String retourServer = read(b2);
            System.out.println(retourServer);
            JFrame fenResp = new JFrame();
            if (retourServer == "") {
                retourServer = "Cet emplacement n'existe pas";
                fenResp.setTitle("Emplacement inexistant !");
            } else {
                Emplacements eRespFind = gson.fromJson(retourServer, Emplacements.class);
                retourServer = "idEmplacement: " + eRespFind.getIdEmplacement() + " location : " + eRespFind.getLocalisation() + " superficie: " + eRespFind.getSuperficie() + " Catégorie: " + eRespFind.getCategorie() + " Taux Occup.: " + eRespFind.getTauxOccupation();
                fenResp.setTitle("Information sur l'emplacement n°" + eRespFind.getIdEmplacement());
            }
            JPanel containerResp = new JPanel();
            fenResp.setSize(600,300);
            fenResp.setLocationRelativeTo(null);
            JLabel jlabResp = new JLabel(retourServer);
            containerResp.add(jlabResp, BorderLayout.CENTER);
            fenResp.setContentPane(containerResp);
            fenResp.setVisible(true);
            s.close();
        }catch (IOException e){}
    }

}
