package controler;

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
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            FileOutputStream out = new FileOutputStream(new File("Client_received.json"));
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
