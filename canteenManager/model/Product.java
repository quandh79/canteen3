package canteenManager.model;

public class Product {
    public Integer id;
    public String productName;
    public Integer price;
    public String note;

    public Product(){

    }

    public Product(Integer id, String productName, Integer price, String note) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    @Override
    public  String toString(){
        return getProductName();
    }
}
