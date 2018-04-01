package controler;

import com.google.gson.Gson;
import connexion.PoolDeConnexion;
import dao.EmplacementsDAO;
import pojo.Emplacements;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;

public class ServerProcessor implements Runnable {

    private Socket sock;
    private PrintWriter writer = null;
    private BufferedInputStream reader=null;
    private PoolDeConnexion connection;

    public ServerProcessor(Socket s, PoolDeConnexion connection){
        this.connection = connection;
        this.sock=s;

    }

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
                    case "AJOUT":
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
                    case "DELETE":
                        break;
                    case "UPDATE:":
                        break;
                    case "FIND":
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

                }


            }catch (IOException e){
                e.printStackTrace();
            }

        }

    }

    private String read() throws IOException {
        String response ="";
        int stream;
        byte[] b = new byte[4096];
        stream = reader.read(b);
        response = new String(b, 0, stream);
        return response;
    }
}
