package pojo;

public class ClientPurchaseList {
    private String productName;
    private float price;
    private int quantity;
    private float totalPrice;
    public ClientPurchaseList(String productName, float price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice= quantity*price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
