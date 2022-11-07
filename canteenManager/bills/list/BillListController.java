package canteenManager.bills.list;

import canteenManager.dao.BillRepository;
import canteenManager.dao.ProductRepository;
import canteenManager.enums.RepoType;
import canteenManager.factory.RepositoryFactory;
import canteenManager.model.Bill;
import canteenManager.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class BillListController implements Initializable {
    public TableView<Bill> tbBills;
    public TableColumn<Bill,Integer> tdIdBill;
    public TableColumn<Bill,String> tdProduct;
    public TableColumn<Bill,Integer> tdQty;
    public TableColumn<Bill,Integer> tdTotal;

    public TableColumn<Bill,String> tdNote;

    public ComboBox<Product> cbProduct;
    public TextField txtQty;
    public TextField txtTotal;
    public TextArea txtNote;
    public  ObservableList<Bill> ls;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //tb
        tdIdBill.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdProduct.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tdQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        tdTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tdNote.setCellValueFactory(new PropertyValueFactory<>("note"));
        ls = FXCollections.observableArrayList();
        BillRepository bi = (BillRepository) RepositoryFactory.creatRepository(RepoType.BILL);
        ls.addAll(bi.all());
        tbBills.setItems(ls);
        //cb
        ProductRepository pr=new ProductRepository();
        ObservableList<Product> lsCb= FXCollections.observableArrayList();
        lsCb.addAll(pr.all());
        cbProduct.setItems(lsCb);
    }

    public void submit(ActionEvent actionEvent) {
        try {

            Product selected = cbProduct.getSelectionModel().getSelectedItem();
            int productNames = selected.getId();
            Integer qty = Integer.parseInt(txtQty.getText());
            Integer total = Integer.parseInt(String.valueOf(selected.getPrice() * qty));
            String note = txtNote.getText();
            Bill bill = new Bill(null,productNames,qty,total,note);
            BillRepository b = new BillRepository();
            if (b.creat(bill)){

            }else {System.out.println("Error");}

            // hien thi tb

            BillRepository bi = (BillRepository) RepositoryFactory.creatRepository(RepoType.BILL);
            ls.addAll(bi.all());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void delete(ActionEvent actionEvent) {
        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Are you sure delete bill");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == ButtonType.OK){
                Bill selected = tbBills.getSelectionModel().getSelectedItem();
                BillRepository rp = new BillRepository();
                rp.delete(selected);

            }else {System.out.println("Error");}
//            BillRepository bi = (BillRepository) RepositoryFactory.creatRepository(RepoType.BILL);
//            ls.addAll(bi.all());
        }catch (Exception e){System.out.println(e.getMessage());}

    }
}
