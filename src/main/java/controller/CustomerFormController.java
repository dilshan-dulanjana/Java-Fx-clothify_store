package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import dto.Customer;
import util.CrudUtil;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private JFXComboBox<String> cmbTitle;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private DatePicker dateDob;

    @FXML
    private TableView<Customer> tblCustomers;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPostalCode;

    @FXML
    private JFXTextField txtProvince;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    void btnAddOnAction(ActionEvent event) {

String SQL="INSERT INTO customer VALUES(?,?,?,?,?,?,?,?,?)";

     Customer customer =  new Customer(txtCustomerId.getText(),
             cmbTitle.getValue(),
             txtName.getText(),
             dateDob.getValue(),
             Double.parseDouble(txtSalary.getText()),
             txtAddress.getText(),
             txtCity.getText(),
             txtProvince.getText(),
             txtPostalCode.getText());
        try {

           boolean isExecute= CrudUtil.execute(
                   SQL,
                   customer.getId(),
                   customer.getTitle(),
                   customer.getName(),
                   customer.getDob(),
                   customer.getSalary(),
                   customer.getAddress(),
                   customer.getCity(),
                   customer.getProvince(),
                   customer.getPostalCode());


            if(isExecute){

                new Alert(Alert.AlertType.INFORMATION,"Customer Added:").show();
                loadTable();
            }


        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer Not Added:").show();
        }

        System.out.println(customer);

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        String SQL ="DELETE FROM customer WHERE CustID='"+txtCustomerId.getText()+"' ";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            boolean isDelete= connection.createStatement().executeUpdate(SQL)>0;

            if(isDelete){

                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted Successfully !").show();
               loadTable();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer Deleted Failed !").show();
        }
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String SQL ="SELECT * FROM customer WHERE CustID=? ";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setObject(1,txtCustomerId.getText());
            ResultSet resultSet = pstm.executeQuery();
            resultSet.next();

            setValueToText(new Customer(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4).toLocalDate(),
                    resultSet.getDouble(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8),
                    resultSet.getString(9)

            ));



        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Customer Not Found!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        Customer customer =  new Customer(txtCustomerId.getText(),
                cmbTitle.getValue(),
                txtName.getText(),
                dateDob.getValue(),
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostalCode.getText());


        String SQL="Update customer SET CustName=?,CustTitle=?,DOB=?,salary=?,custAddress=?,city=?,Province=?,PostalCode=? WHERE custID=? ";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(SQL);
            pstm.setObject(1,customer.getName());
            pstm.setObject(2,customer.getTitle());
            pstm.setObject(3,customer.getDob());
            pstm.setObject(4,customer.getSalary());
            pstm.setObject(5,customer.getAddress());
            pstm.setObject(6,customer.getCity());
            pstm.setObject(7,customer.getProvince());
            pstm.setObject(8,customer.getPostalCode());
            pstm.setObject(9,customer.getId());

            boolean isupdated = CrudUtil.execute(
                    SQL,
                    customer.getName(),
                    customer.getTitle(),
                    customer.getDob(),
                    customer.getSalary(),
                    customer.getAddress(),
                    customer.getCity(),
                    customer.getProvince(),
                    customer.getPostalCode(),
                    customer.getId());

            if(isupdated) {
                loadTable();
                new Alert(Alert.AlertType.INFORMATION, "Customer Data Update Successfully!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.INFORMATION,"Update Failed!").show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadTable();

        ObservableList<String> customerTitleList = FXCollections.observableArrayList();
        customerTitleList.add("Mr");
        customerTitleList.add("Mrs");
        customerTitleList.add("Miss");
        customerTitleList.add("Ms");
        cmbTitle.setItems(customerTitleList);

        tblCustomers.getSelectionModel().selectedItemProperty().addListener((observableValue, customer, newvalue) ->{
            if(newvalue!=null){
                setValueToText(newvalue);
            }
        } );
    }

    public void setValueToText(Customer newvaue){

        txtCustomerId.setText(newvaue.getId());
        txtName.setText(newvaue.getName());
        cmbTitle.setValue(newvaue.getTitle());
        txtPostalCode.setText(newvaue.getPostalCode());
        txtProvince.setText(newvaue.getProvince());
        txtSalary.setText(newvaue.getSalary().toString());
        dateDob.setValue(newvaue.getDob());
        txtAddress.setText(newvaue.getAddress());
        txtCity.setText(newvaue.getCity());
    }



    public void loadTable(){

        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");

            String SQL ="SELECT * FROM customer";

            ResultSet resultSet = connection.createStatement().executeQuery(SQL);

            while (resultSet.next()){
                Customer customer = new Customer(
                        resultSet.getString("CustID"),
                        resultSet.getString("CustTitle"),
                        resultSet.getString("CustName"),
                        resultSet.getDate("dob").toLocalDate(),
                        resultSet.getDouble("salary"),
                        resultSet.getString("CustAddress"),
                        resultSet.getString("city"),
                        resultSet.getString("province"),
                        resultSet.getString("postalCode")
                );
                customerObservableList.add(customer);
            }

            tblCustomers.setItems(customerObservableList);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
