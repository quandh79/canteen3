package canteenManager.dao;

import canteenManager.dao.DAOInterface;
import canteenManager.database.Connector;
import canteenManager.model.Product;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository implements DAOInterface<Product> {
    @Override
    public ArrayList<Product> all() {
        ArrayList<Product> ls=new ArrayList<>();
        try {
            String sql_txt="select * from product";
            Connector conn=Connector.getInstance();
            ResultSet rs= conn.query(sql_txt);
            while (rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("productName");
                int price= rs.getInt("price");
                String note= rs.getString("note");
                Product prd= new Product(id,name,price,note);
                ls.add(prd);
            }
        }catch (Exception e){

        }
        return ls;
    }

    @Override
    public boolean creat(Product product) {
        return false;
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public Product findOne(Integer id) {
        try {
            String sql_txt = "select * from product where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()){
                int Id = rs.getInt("id");
                String name=rs.getString("productName");
                int price= rs.getInt("price");
                String note= rs.getString("note");
                return new Product(Id,name,price,note);
            }
        }catch (Exception e){}
        return null;
    }
}
