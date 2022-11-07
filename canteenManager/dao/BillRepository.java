package canteenManager.dao;

import canteenManager.database.Connector;
import canteenManager.model.Bill;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BillRepository implements DAOInterface<Bill> {
    @Override
    public ArrayList<Bill> all() {
        ArrayList<Bill> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from bills";
            canteenManager.database.Connector conn = canteenManager.database.Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                int productId = rs.getInt("productId");
                int qty = rs.getInt("qty");
                int total = rs.getInt("total");
                String note = rs.getString("note");
                Bill b = new Bill(id,productId,qty,total,note);
                ls.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return ls;
    }

    @Override
    public boolean creat(Bill bill) {
        try {
            String sql_txt = "insert into bills(productId,qty,total,note) values(?,?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bill.getProductId());
            arr.add(bill.getQty());
            arr.add(bill.getTotal());
            arr.add(bill.getNote());
            if (conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){}

        return false;
    }

    @Override
    public boolean delete(Bill bill) {
        try {
            String sql_txt = "delete from bills where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(bill.getId());
            if (conn.execute(sql_txt,arr)){ return true;}
        }catch (Exception e){}

        return false;
    }

    @Override
    public Bill findOne(Integer id) {
        return null;
    }
}
