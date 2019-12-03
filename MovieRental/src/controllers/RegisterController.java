package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import application.Main;
import dao.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RegisterController extends DBConnect {
@FXML
private Pane pane1;
@FXML
private TextField txtName;
@FXML
private TextField txtAddress;
@FXML
private TextField txtGender;
@FXML
private TextField txtPhone;
@FXML
private TextField txtAge;
@FXML
private TextField txtUsername;
@FXML
private PasswordField txtPassword;

@SuppressWarnings("unused")
//private AdminModel am;
// Declare DB objects
DBConnect conn = null;
Statement stmt = null;


// public void updateMovie() {
// pane3.setVisible(false);
// pane2.setVisible(false);
// pane1.setVisible(true);
// }
// public void deleteMovie() {
// pane1.setVisible(false);
// pane2.setVisible(true);
// pane3.setVisible(false);
// }
//
// public void addMovie() {
// pane1.setVisible(false);
// pane2.setVisible(false);
// pane3.setVisible(true);
// }

@SuppressWarnings("unused")
public void register() throws SQLException {

String name=this.txtName.getText();
String address=this.txtAddress.getText();
String gender=this.txtGender.getText();
String phone=this.txtPhone.getText();
String age=this.txtAge.getText();
String uname=this.txtUsername.getText();
String pass=this.txtPassword.getText();
AddUser(name,address,gender,phone,age);
AddUserCred(uname, pass);
}
@SuppressWarnings("unused")
private boolean AddUser(String name, String address, String gender, String phone, String age) {
// TODO Auto-generated method stub
String query = "INSERT INTO movie_customer (Name,Address,Gender,Phone,Age)" +"VALUES(?,?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, name);
           stmt.setString(2, address);
           stmt.setString(3, gender);          
           stmt.setString(4, phone);
           stmt.setString(5, age);
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Welcome!!!");
    alert.setHeaderText("New user");
    alert.setContentText("!!!");
    alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        e.printStackTrace();  
         }
       return false;
}

private boolean AddUserCred(String uname, String pass) {
	// TODO Auto-generated method stub
	String query = "INSERT INTO m_user (username,password,user_type)" +"VALUES(?,?,?)";
	        try(PreparedStatement stmt = connection.prepareStatement(query)) {
	           stmt.setString(1, uname);
	           stmt.setString(2, pass);
	           stmt.setInt(3, '0');
	           boolean rs = stmt.execute();
	           return true;            
	         }catch (SQLException e) {
	        e.printStackTrace();  
	         }
	       return false;
	}
public RegisterController() {
conn = new DBConnect();
}

public void logout() {
//System.exit(0);
try {
AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
Scene scene = new Scene(root);
//scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
Main.stage.setScene(scene);
Main.stage.setTitle("Login");
} catch (Exception e) {
System.out.println("Error occured while inflating view: " + e);
}
}
}
