package canteenManager.product;


import canteenManager.Main;
import canteenManager.dao.ProductRepository;
import canteenManager.enums.RepoType;
import canteenManager.factory.RepositoryFactory;
import canteenManager.model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    public TableView<Product> cbProduct;
    public TableColumn<Product,Integer> idP;
    public TableColumn<Product, String> pName;
    public TableColumn<Product,Integer> price;
    public TableColumn<Product,String> note;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idP.setCellValueFactory(new PropertyValueFactory<Product,Integer>("id"));
        pName.setCellValueFactory(new PropertyValueFactory<Product,String>("productName"));
        price.setCellValueFactory(new PropertyValueFactory<Product,Integer>("price"));
        note.setCellValueFactory(new PropertyValueFactory<Product,String>("note"));
        ObservableList<Product> ls= FXCollections.observableArrayList();
        ProductRepository pr=(ProductRepository) RepositoryFactory.creatRepository(RepoType.Product);
        ls.addAll(pr.all());
        cbProduct.setItems(ls);

    }

    public void goToBill(ActionEvent actionEvent) throws IOException {
        Parent listBook = FXMLLoader.load(getClass().getResource("../bill/bill.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
