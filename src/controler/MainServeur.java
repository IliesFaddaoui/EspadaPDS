package controler;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import pojo.Emplacements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileReader;


public class MainServeur {
    public static void main(String[]args){
        Server s1 = new Server();
        s1.open();

    }

}
