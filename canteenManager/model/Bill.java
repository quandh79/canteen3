package canteenManager.model;

import canteenManager.dao.ProductRepository;
import canteenManager.enums.RepoType;
import canteenManager.factory.RepositoryFactory;

public class Bill {
    public Integer id;
    public  Integer productId;
    public  Integer qty;
    public  Integer total;
    public  String note;

    public String productName;
    public Integer priceProduct;

    public Bill(Integer id, String selected, Integer qty, Integer total, String note) {
    }

    public Bill(Integer id, Integer productId, Integer qty, Integer total, String note) {
        this.id = id;
        this.productId = productId;
        this.qty = qty;
        this.total = total;

        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getProductName() {
        return this.product().getProductName();
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPriceProduct() {
        return this.product().getPrice();
    }

    public void setPriceProduct(Integer priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Product product(){
        return ((ProductRepository) RepositoryFactory.creatRepository(RepoType.Product)).findOne(this.getProductId());
    }
}
