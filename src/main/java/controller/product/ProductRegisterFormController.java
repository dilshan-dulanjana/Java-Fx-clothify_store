package controller.product;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Product;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.Duration;
import service.ServiceFactory;
import service.custom.ProductServices;
import util.ServiceType;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.ResourceBundle;

public class ProductRegisterFormController  implements Initializable {

    public Label lblenterdate;
    public DatePicker dateproductenterdate;
    public Label lbldateandtime;
    @FXML
    private JFXComboBox<String> cmbcategory;

    @FXML
    private Label lblbarcode;

    @FXML
    private JFXTextField txtproductID;

    @FXML
    private JFXTextField txtproductName;

    @FXML
    private JFXTextField txtqty;

    @FXML
    private JFXTextField txtsize;

    @FXML
    private JFXTextField txtunitPrice;


    ProductController productController = new ProductController();
    @FXML
    void btnSearchOnAction(ActionEvent event) {
        setValuesToText(productController.searchProduct(txtproductID.getText()));
    }

    @FXML
    void btnaddproductOnAction(ActionEvent event) {
        Product product =new Product(
                lblbarcode.getText(),
                txtproductID.getText(),
                txtproductName.getText(),
                Double.parseDouble( txtqty.getText()) ,
                txtsize.getText(),
                Double.parseDouble(txtunitPrice.getText()) ,
                dateproductenterdate.getValue(),
                cmbcategory.getValue()

        );

        if(productController.addProduct(product)){
            new Alert(Alert.AlertType.INFORMATION,"Product Added!").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Customer Not Added!").show();
        }

    }

    @FXML
    void btndeletOnAction(ActionEvent event) {

       if( productController.deleteProduct(txtproductID.getText())){
           new Alert(Alert.AlertType.INFORMATION, " Delete Successfully!").show();
       }
       else{
           new Alert(Alert.AlertType.ERROR, " Delete  Failed!").show();
       }
    }

    @FXML
    void btnupdateproductOnAction(ActionEvent event) {

        Product product =new Product(
                lblbarcode.getText(),
                txtproductID.getText(),
                txtproductName.getText(),
                Double.parseDouble( txtqty.getText()) ,
                txtsize.getText(),
                Double.parseDouble(txtunitPrice.getText()) ,
                dateproductenterdate.getValue(),
                cmbcategory.getValue()

        );

        if(productController.updateProduct(product)){
            new Alert(Alert.AlertType.INFORMATION, " Update Successfully!").show();
        }else {

            new Alert(Alert.AlertType.ERROR, "Update Failed!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> productCategoryList = FXCollections.observableArrayList();
        productCategoryList.add("Mens");
        productCategoryList.add("Ladies");
        productCategoryList.add("Childrens");
       cmbcategory.setItems(productCategoryList);
        dateproductenterdate.setValue(LocalDate.parse(LocalDate.now().toString()));

        loadTime();
    }

    public void setValuesToText(Product newValue){
        lblbarcode.setText(newValue.getBarcode());
        txtproductID.setText(newValue.getProductID());
        txtproductName.setText(newValue.getName());
        txtqty.setText(newValue.getQty().toString());
        txtsize.setText(newValue.getSize());
        txtunitPrice.setText(newValue.getUnitPrice().toString());
        cmbcategory.setValue(newValue.getCategory());
        dateproductenterdate.setValue(newValue.getEnterdate() );
    }
    private void loadTime() {

        // ---------------------------------------------

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime now = LocalTime.now();
            lbldateandtime.setText(
                    now.getHour() + " : " + now.getMinute() + " : " + now.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
}




