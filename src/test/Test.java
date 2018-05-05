package test;

import connexion.PoolDeConnexion;
import dao.ClientDAO;
import pojo.Client;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[]args){

        PoolDeConnexion connection= new PoolDeConnexion(5);

        ClientDAO c1 = new ClientDAO(connection.getConnection());
        Client cli = c1.find(1);
        System.out.println("nom: "+ cli.getClientName());
        /*List<String> s1 = c1.listOfClients();
        if(s1.isEmpty())
            System.out.println("remplie");
        else
            System.out.println("vide");
        for(String str:s1)
            System.out.println(str);
        */

    }
}
