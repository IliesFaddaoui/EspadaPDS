package pojo;
/**
 * @author Ilies
 * @version 2
 * This is the Product data model
 */
public class Product {

    private int idProduct;
    private String productReference;
    private int price;
    private int keyWord;

    public Product(int idProduct, String productReference, int price, int keyWord) {
        this.idProduct = idProduct;
        this.productReference = productReference;
        this.price = price;
        this.keyWord = keyWord;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getProductReference() {
        return productReference;
    }


    public int getPrice() {
        return price;
    }

    public int getKeyWord() {
        return keyWord;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setProductReference(String productReference) {
        this.productReference = productReference;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKeyWord(int keyWord) {
        this.keyWord = keyWord;
    }
}
