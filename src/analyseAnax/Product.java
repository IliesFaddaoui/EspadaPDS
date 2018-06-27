package analyseAnax;
/**
 * @author Ilies
 * @version 2
 * This is the Product data model
 */
public class Product {

    private int idProduct;
    private String productReference;
    private float price;
    private int keyWord;

    public Product(int idProduct, String productReference, float price, int keyWord) {
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


    public float getPrice() {
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

    public void setPrice(float price) {
        this.price = price;
    }

    public void setKeyWord(int keyWord) {
        this.keyWord = keyWord;
    }
}
