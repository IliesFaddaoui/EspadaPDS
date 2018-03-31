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
                String demande = read();
                System.out.println("objet recu: " +demande);
                Emplacements e1 = gson.fromJson(demande, Emplacements.class);
                System.out.println("objet crée : ");
                System.out.println("idEmplacement: "+ e1.getIdEmplacement() + "localisation" + e1.getLocalisation());
                EmplacementsDAO d = new EmplacementsDAO(connection.getConnection());
                d.create(e1);
                System.out.println("Insertion par le dao effectué, vérification en cours...");
                Emplacements e2 = d.find(e1.getIdEmplacement());
                System.out.println("objet créé trouvé ! idEmplacement= "+ e2.getIdEmplacement() + " localisation: " + e2.getLocalisation());


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
