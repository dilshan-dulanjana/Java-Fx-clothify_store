package controller.oder;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.product.ProductController;
import dto.CartItems;
import dto.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {

    public Label lblbarcode;
    public Label lblorderID;
    public Label lblproductname;
    public Label lblpriceperunit;
    public Label lblsize;
    public Label lblcategory;
    public TextField txtqty;
    public Label lblamount;
    public JFXButton btnAddtocart;
    public JFXComboBox cmbpaymentType;
    public JFXTextField txtproductId;
    public TableView tblcart;
    public TableColumn colname;
    public TableColumn colsize;
    public TableColumn colqty;
    public TableColumn colamount;
    public Label lbltotalAmount;
    public Label lblallQty;
    public Label lbldate;
    @FXML
    private JFXComboBox<?> cmbTitle;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<?> tblCustomers;

    @FXML
    private JFXTextField txtCustomerId;

    Double updateqty=0.0;

    PlaceOrderController placeOrderController = new PlaceOrderController();
    ProductController productController = new ProductController();
    @FXML

    void btnSearchOnAction(ActionEvent event) {

       setValuestoTextProduct(productController.searchProduct(txtproductId.getText()));
    }

    private void setValuestoTextProduct(Product product) {

        lblproductname.setText(product.getName());
        lblpriceperunit.setText(product.getUnitPrice().toString());
        lblsize.setText(product.getSize());
        lblcategory.setText(product.getCategory());
        lblbarcode.setText(product.getBarcode());
        lblallQty.setText(product.getQty().toString());
        updateqty= product.getQty();
    }

    ObservableList<CartItems> cart = FXCollections.observableArrayList();

    @FXML
    void btnaddtocartOnAction(ActionEvent event) {
        Double unitPrice = Double.parseDouble(lblpriceperunit.getText());
        Double qty = Double.parseDouble(txtqty.getText());

        Double total = unitPrice * qty;
        updateqty-=qty;
       lblallQty.setText(updateqty.toString());
        cart.add(
                new CartItems(
                        lblorderID.getText(),
                        txtproductId.getText(),
                        lblproductname.getText(),
                        qty,
                        total,
                        cmbpaymentType.getValue().toString(),
                        "EMP"

                )
        );

        tblcart.setItems(cart);
        calcNetTotal();

    }

    @FXML
    void btncancelorderOnAction(ActionEvent event) {
    cart.clear();
    calcNetTotal();
        new Alert(Alert.AlertType.INFORMATION, "Order is Canceled!").show();
    }

    @FXML
    void btnplaceorderOnAction(ActionEvent event) {




    }

    @FXML
    void btnprintOnAction(ActionEvent event) {

    }

    @FXML
    public void btnremovecartItemOnAction(ActionEvent event) {

        System.out.println("Check");

        Object selectedItem = tblcart.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {

            cart.remove(selectedItem);
            System.out.println("Removed item: " + selectedItem);
            calcNetTotal();

            new Alert(Alert.AlertType.INFORMATION, "Item Removed Successfully!").show();
        } else {

            new Alert(Alert.AlertType.WARNING, "No item selected to remove!").show();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> productCategoryList = FXCollections.observableArrayList();
        productCategoryList.add("Cash");
        productCategoryList.add("Card Payment");
        productCategoryList.add("Online Bank Payment");
        cmbpaymentType.setItems(productCategoryList);
       setValuestoTextProduct(new Product("Barcode", "", "", 0.0,"", 0.0, LocalDate.now(), ""));


        colname.setCellValueFactory(new PropertyValueFactory<>("description"));
        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colamount.setCellValueFactory(new PropertyValueFactory<>("total"));



    }

    public void lblqtyOnkeyTypedAction(KeyEvent keyEvent) {


        lblamount.setText(String.valueOf(Double.valueOf(lblpriceperunit.getText())*Double.valueOf(txtqty.getText())));


    }

    private void calcNetTotal() {
        Double total = 0.0;

        for (CartItems cartTM : cart) {
            total += cartTM.getTotal();
        }

        lbltotalAmount.setText(total.toString());


    }
  //  barcodeID, productId, name, qty, size, unitPrice, date, category
    public void UpdateQty(){
        for (CartItems cartTM : cart) {
            Product product =new Product(
                    lblbarcode.getText(),
                    txtproductId.getText(),
                    lblproductname.getText(),
                   Double.parseDouble(lblallQty.getText())- cartTM.getQty(),
                    lblsize.getText(),
                    Double.parseDouble(lblpriceperunit.getText()) ,
                      LocalDate.now()  ,
                    lblcategory.getText()

            );
           // productController.updateProduct()
        }
        //productController.updateProduct();
    }
}
