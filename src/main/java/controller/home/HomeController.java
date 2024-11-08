package controller.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HomeController {

    public Button btnproduct;
    public Button btnsupplier;
    @FXML
    private BorderPane root; // Link to the main BorderPane

    @FXML
    private Button btnemployer;

    @FXML
    private Button btnhome;

    @FXML
    private Button btnplaceOrder;

    @FXML
    private Button btnprofile;

    @FXML
    private Button btnreport;

    @FXML
    private Pane pane1; // This should match fx:id in your FXML


    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {
        Pane interface1 = loadInterface("/view/PlaceOrder.fxml"); // Adjust path as needed
        if (interface1 != null) { // Check if loaded successfully
            pane1.getChildren().setAll(interface1.getChildren()); // Load new content
        } else {
            System.out.println("Failed to load interface: PlaceOrder.fxml");
        }
    }

    private Pane loadInterface(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            return loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Handle this case as needed
        }
    }

    @FXML
    void btnemployerOnAction(ActionEvent event) {
        Pane interface1 = loadInterface("/view/Employer_Form.fxml");
        if (interface1 != null) {
            pane1.getChildren().setAll(interface1.getChildren());
        } else {
            System.out.println("Failed to load interface: Employer_Form.fxml");
        }
    }

    @FXML
    void btnhomeOnAction(ActionEvent event) {
        Pane interface1 = loadInterface("/view/Home.fxml");
        if (interface1 != null) {
            pane1.getChildren().setAll(interface1.getChildren());
        } else {
            System.out.println("Failed to load interface: Home.fxml");
        }
    }

    @FXML
    void btnprofileOnAction(ActionEvent event) {
        // Implement actions
    }

    @FXML
    void btnreportOnAction(ActionEvent event) {
        // Implement actions
    }

    public void btnproductOnAction(ActionEvent actionEvent) {

        Pane interface1 = loadInterface("/view/ProductRegister.fxml");
        if (interface1 != null) {
            pane1.getChildren().setAll(interface1.getChildren());
        } else {
            System.out.println("Failed to load interface: Product register.fxml");
        }
    }

    public void btnsupplierOnAction(ActionEvent actionEvent) {

        Pane interface1 = loadInterface("/view/Supplier.fxml"); // Adjust path as needed
        if (interface1 != null) { // Check if loaded successfully
            pane1.getChildren().setAll(interface1.getChildren()); // Load new content
        } else {
            System.out.println("Failed to load interface: Supplier.fxml");
        }
    }
}
