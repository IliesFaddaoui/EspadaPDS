package test;

import connexion.PoolDeConnexion;
import dao.ClientDAO;
import dao.MagasinsDAO;
import dao.ProductDAO;
import pojo.Client;
import pojo.Magasins;
import pojo.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[]args){

        PoolDeConnexion connection= new PoolDeConnexion(5);

        /*
        Test client ok
        ClientDAO c1 = new ClientDAO(connection.getConnection());
        Client cli = c1.find(1);
        System.out.println("nom: "+ cli.getClientName());
        Client cli2 = new Client(3, "rob123", "rob123","sylvestre", "robert", "012012", "5 rue soleil", "male");

        c1.create(cli2);
        c1.find(3);
        System.out.println(cli2.getIdClient() + " "+ cli2.getClientSurname() +" " + cli2.getPhone());
        Client cli3 = new Client(3,"rob123", "rob123@", "sylvestre", "robert", "0102030405", "5 rue soleil", "male");
        c1.update(cli3);
        System.out.println("update bien effectué, nouveau mdp= " + c1.find(3).getPassword());

        c1.delete(cli2);
        System.out.println("Client bien supprimé");
        */

        ProductDAO m1 = new ProductDAO(connection.getConnection());




    }
}
