package controller.supplier;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierFormController implements Initializable {

    public Label lblsupplierID;
    @FXML
    private JFXButton btnaddSupplier;

    @FXML
    private JFXButton btnremoveSupplier;

    @FXML
    private JFXButton btnupdateSupplier;

    @FXML
    private JFXComboBox<String> cmbselectEmployee;

    @FXML
    private ImageView img1;

    @FXML
    private JFXTextField txtsupplierAddress;

    @FXML
    private JFXTextField txtsupplierEmail;

    @FXML
    private JFXTextField txtsupplierName;

    @FXML
    private JFXTextField txtsupplierTelephone;


    SupplierController supplierController = new SupplierController();

    @FXML
    void btnaddSupplieronAction(ActionEvent event) {

        Supplier supplier = new Supplier(
                Integer.getInteger(lblsupplierID.getText()),
                txtsupplierName.getText(),
                txtsupplierEmail.getText(),
                txtsupplierAddress.getText(),
                txtsupplierTelephone.getText()
        );

        if (supplierController.addSupplier(supplier)) {
            setSupplierID();
            load();

            new Alert(Alert.AlertType.INFORMATION, "Supplier Added!").show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Failed Added!").show();
        }

    }

    @FXML
    void btnremoveSupplier(ActionEvent event) {


    }

    @FXML
    void btnupdateSupplier(ActionEvent event) {

    }

    @FXML
    void cmbselectSupplierOnAction(ActionEvent event) {
        Supplier supplier = supplierController.selectedSupplier(cmbselectEmployee.getValue());
        lblsupplierID.setText(supplier.getID().toString());
        txtsupplierName.setText(supplier.getName());
        txtsupplierEmail.setText(supplier.getEmail());
        txtsupplierAddress.setText(supplier.getAddress());
        txtsupplierTelephone.setText(supplier.getTelephone());

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        load();

        setSupplierID();
    }

    public void load() {
        ObservableList<Supplier> allSupplier = supplierController.getAllSupplier();
        ObservableList<String> suppliyenameList = FXCollections.observableArrayList();


        for (Supplier supplier : allSupplier) {
            suppliyenameList.add(supplier.getName());

        }
        cmbselectEmployee.setItems(suppliyenameList);

    }

    public void setSupplierID() {
        Integer nextID = supplierController.setsuplierID() + 1;

        lblsupplierID.setText(nextID.toString());

    }


}
