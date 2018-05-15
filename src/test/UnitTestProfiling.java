package test;
import static org.junit.Assert.*;

import clientSocket.SocketClientProfile;
import connexion.PoolDeConnexion;
import dao.ClientDAO;
import dao.KeyWordDAO;
import dao.ProductDAO;
import org.junit.Test;
import pojo.Client;
import pojo.KeyWord;
import pojo.Product;

import java.sql.Connection;

public class UnitTestProfiling {
    PoolDeConnexion connection;
    public UnitTestProfiling(){
        this.connection = new PoolDeConnexion(5);
    }
    @Test
    public final void testIdentificationDAO(){
        SocketClientProfile s1 = new SocketClientProfile();
        Client c1 = s1.getClientInformation("ilies123", "ilies123");
        if(c1 == null)
            fail("socket can't find client with login");
    }

    @Test
    public final void testClientDAO(){
        Connection connClient = this.connection.getConnection();
        ClientDAO c1 = new ClientDAO(connClient);
        Client cli = c1.find(1);
        if(cli== null)
            fail("can't find client");
        Client cli2 = new Client(3, "rob123", "rob123","sylvestre", "robert", "012012", "5 rue soleil", "male");
        c1.create(cli2);
        if(c1.find(3)==null)
            fail("Client not created");
        Client cli3 = new Client(3,"rob123", "rob123@", "sylvestre", "robert", "0102030405", "5 rue soleil", "male");
        c1.update(cli3);
        if(!c1.find(3).getPseudo().equals("rob123"));
            fail("Update don't done ");
        c1.delete(cli2);
        if(c1.find(3)!= null)
            fail("Delete don't word");
        this.connection.releaseConnection(connClient);
    }

    @Test
    public final void testKeywordDAO(){
        Connection connKeyword = this.connection.getConnection();
        KeyWordDAO k1 = new KeyWordDAO(connKeyword);
        KeyWord kw1 = k1.find(1);
        if(kw1==null)
            fail("can't find client");
        KeyWord kw2 = new KeyWord(10, "radio");
        k1.create(kw2);
        if(k1.find(10)==null)
            fail("Client not created");
        KeyWord kw3 = new KeyWord(10, "lecteur dvd");
        k1.update(kw3);
        if(!k1.find(10).getNameKeyWord().equals("lecteur dvd"))
            fail("Update don't done ");
        k1.delete(kw3);
        if(k1.find(10)!= null)
            fail("Delete don't word");
        this.connection.releaseConnection(connKeyword);
    }

    @Test
    public final void testProductDAO(){
        Connection conProduct = this.connection.getConnection();
        ProductDAO m1 = new ProductDAO(conProduct);
        Product p2 = new Product(10, " opop",100,2);
        m1.create(p2);
        if(p2==null)
            fail("Product not created");
        Product p3= new Product(10, " apapapaap",100,2);
        m1.update(p3);
        if(!m1.find(10).getProductReference().equals(" apapapaap"))
            fail("Update don't work");
        m1.delete(p3);
        if(m1.find(10)!= null)
            fail("Delete don't work");
        this.connection.releaseConnection(conProduct);
    }

}


