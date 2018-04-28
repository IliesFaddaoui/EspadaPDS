package pojo;

public class Product {

    private int idProduct;
    private String productReference;
    private int stock;
    private int price;
    private String keyWord;

    public Product(int idProduct, String productReference, int stock, int price, String keyWord) {
        this.idProduct = idProduct;
        this.productReference = productReference;
        this.stock = stock;
        this.price = price;
        this.keyWord = keyWord;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getProductReference() {
        return productReference;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
