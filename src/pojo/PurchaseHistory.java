package pojo;

import java.util.Date;
/**
 * @author Ilies
 * @version 2
 * This is the PurchaseHistory data model
 */
public class PurchaseHistory {
    private int idPurchase;
    private int idProduct;
    private int idClient;
    private String purchaseDate;
    private int Quantity;

    public PurchaseHistory(int idPurchase, int idProduct, int idClient, String purchaseDate, int quantity) {
        this.idPurchase = idPurchase;
        this.idProduct = idProduct;
        this.idClient = idClient;
        this.purchaseDate = purchaseDate;
        Quantity = quantity;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
