package test;

import connexion.PoolDeConnexion;
import dao.*;
import pojo.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilies
 * @version 2.0
 * This class with a simple main can be use to test dao/model
 *
 */
public class Test {
    public static void main(String[]args){

        PoolDeConnexion connection= new PoolDeConnexion(10);

        /*
        // TEST CLIENT OK
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


        // TEST PRODUCT OK
        ProductDAO m1 = new ProductDAO(connection.getConnection());
        Product p1 = m1.find(1);
        System.out.println("nom du product: " + p1.getProductReference());
        Product p2 = new Product(10, " opop",100,2);
        m1.create(p2);
        System.out.println("update bien effectué, nouveau product= " + m1.find(10).getProductReference());
        Product p3= new Product(10, " apapapaap",100,2);
        m1.update(p3);
        System.out.println("update bien effectué, nouveau nom du nouveau produit= " + m1.find(10).getProductReference());
        m1.delete(p3);
        System.out.println("bien supprimé");

        // TEST Keyword OK

        KeyWordDAO k1 = new KeyWordDAO(connection.getConnection());
        KeyWord kw1 = k1.find(1);
        System.out.println("Premier keyword= "+ kw1.getNameKeyWord());
        KeyWord kw2 = new KeyWord(10, "radio");
        k1.create(kw2);
        System.out.println("bien créé keyword= "+ kw2.getNameKeyWord());
        KeyWord kw3 = new KeyWord(10, "lecteur dvd");
        k1.update(kw3);
        System.out.println("bien mis à jour: name :" + k1.find(10).getNameKeyWord());
        k1.delete(kw3);
        System.out.println("bien supprimé !");

        // TEST PurchaseHistory
        ProductDAO prod = new ProductDAO(connection.getConnection());
        PurchaseHistoryDAO phd1 = new PurchaseHistoryDAO(connection.getConnection());
        PurchaseHistory ph1= phd1.find(1);
        System.out.println("premier achat: " + prod.find(ph1.getIdProduct()).getProductReference());

        // TEST list purchase
        KeyWordDAO k1 = new KeyWordDAO(connection.getConnection());
        List<KeyWordOccurence> l1 = k1.getListKeyWordOccurence(1);

        for (KeyWordOccurence kwol : l1) {
            System.out.println("nom: "+ kwol.getNameKeyWord() + " nbr:" + kwol.getKeyWordOccurence());
        }


        //Test for linkDAO
        LinkClientTPDAO k1 = new LinkClientTPDAO(connection.getConnection());
        List<String> l1 = k1.getClientLinkedTP(1);
        for (String s1 : l1) {
            System.out.println("profile type: "+ s1);
        }
        */
        //Test for linkTPKW
        LinkTPKeyWordDAO k2 = new LinkTPKeyWordDAO(connection.getConnection());
        List<String> l2 = k2.getTPKeywords(1);
        for (String s1 : l2) {
            System.out.println("kw : "+ s1);
        }
    }
}
