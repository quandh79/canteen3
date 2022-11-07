package canteenManager.bill;

import canteenManager.dao.BillRepository;
import canteenManager.dao.ProductRepository;
import canteenManager.database.Connector;
import canteenManager.enums.RepoType;
import canteenManager.factory.RepositoryFactory;
import canteenManager.model.Bill;
import canteenManager.model.Product;
import canteenManager.product.ProductController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class BillController implements Initializable {
    public ComboBox<Product> cbProduct;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductRepository pr=new ProductRepository();
        ObservableList<Product> ls= FXCollections.observableArrayList();
        ls.addAll(pr.all());
        cbProduct.setItems(ls);



        
    }

//    public int GetGiaSanPham(String MaSP) {
//        int Gia = 0;
//        String sql_txt = "select * from product where id=" + MaSP;
//        Connector conn = Connector.getInstance();
//        ResultSet rs = conn.query(sql_txt);
//        try {
//            while (rs.next()) {
//                Gia = rs.getInt("price");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return Gia;
//    }
//
//    public void tongTien(ActionEvent actionEvent) {
//        int SoLuong = 0;
//        double Tien = 0;
//        try {
//            SoLuong = Integer.valueOf(qty.getText());
//        } catch (Exception e) {
//        }
//        int Gia = GetGiaSanPham(cbProduct.getId());
//        Tien = (double) Gia * SoLuong;
//        into.setText(String.valueOf(Tien));
//    }
}
