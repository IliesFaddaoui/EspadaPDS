package controler;

import com.google.gson.Gson;
import pojo.Emplacements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServeur {
    public static void main(String[]args){
        Socket s;
        ServerSocket serv;
        String line;
        
        try {
            serv = new ServerSocket(5000);
            s = serv.accept();
            Gson gson = new Gson();
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader lol = new BufferedReader(in);
			while((line = lol.readLine() )!= null){
				System.out.println(line);
			}		
          
            Emplacements e1 = gson.fromJson(line, Emplacements.class);
            System.out.println("loca: "+ e1.getLocalisation() + " id: "+ e1.getIdEmplacement());

        } catch (Exception e) {}
    }

}
