package controllers;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class CustomerController {
	
	public CustomerController() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Access");
		alert.setHeaderText("Lots of Movies in here");
		alert.setContentText("Welcome user!!!");
		alert.showAndWait();
	}

	static int userid;

	public static void setUserId(int user_id) {
		userid = user_id;
		System.out.println("Welcome id " + userid);
	}
	public void logout() {
		//System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
}
