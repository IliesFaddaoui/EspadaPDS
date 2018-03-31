package controler;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerProcessor implements Runnable {

    private Socket sock;
    private PrintWriter writer = null;
    private BufferedInputStream reader=null;

    public ServerProcessor(Socket s){
        this.sock=s;

    }

    public void run() {
        boolean closeConnexion = false;
        while(!sock.isClosed()){
            try{
                writer = new PrintWriter(sock.getOutputStream());
                reader = new BufferedInputStream(sock.getInputStream());

                String demande = read();
                System.out.println(demande);
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
