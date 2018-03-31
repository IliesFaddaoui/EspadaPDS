package controler;

import connexion.PoolDeConnexion;

import javax.annotation.processing.Processor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {

    private int port =5000;
    private ServerSocket server = null;
    private boolean isRunning = true;

    public Server(){
        try{
            server = new ServerSocket(port, 100, InetAddress.getLocalHost());
        } catch (UnknownHostException e){
            e.printStackTrace();
        } catch (IOException e1){
            e1.printStackTrace();
        }

    }

    public void open(){

        Thread t = new Thread(new Runnable() {

            public void run() {
                PoolDeConnexion con = new PoolDeConnexion(3);
                while (isRunning){
                    try{
                        Socket s1 = server.accept();
                        Thread t = new Thread(new ServerProcessor(s1, con));
                        t.start();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }

                try{
                    server.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        t.start();
    }

    public void close(){
        isRunning = false;
    }
}
