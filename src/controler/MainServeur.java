package controler;

import com.google.gson.Gson;
import pojo.Emplacements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServeur {
    public static void main(String[]args){
        Socket s;
        ServerSocket serv;
        try {
            serv = new ServerSocket(5000);
            s = serv.accept();
            Gson gson = new Gson();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            FileOutputStream out = new FileOutputStream(new File("Client_received.json"));
            String json = gson.toJson(out);
            Emplacements e1 = gson.fromJson(json, Emplacements.class);
            System.out.println("loca: "+ e1.getLocalisation() + " id: "+ e1.getIdEmplacement());

            byte buf[] = new byte[1024];
            int n;
            while ((n = in.read(buf)) != -1) {
                out.write(buf, 0, n);
            }
            out.close();
            s.close();
        } catch (Exception e) {}
    }

}
