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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class buymovieController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField txtMovie	;
	
	@SuppressWarnings("unused")
	//private AdminModel am;
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	
//	public void updateMovie() {
//		pane3.setVisible(false);
//		pane2.setVisible(false);
//		pane1.setVisible(true);
//	}
//	public void deleteMovie() {
//		pane1.setVisible(false);
//		pane2.setVisible(true); 
//		pane3.setVisible(false);
//	}
//
//	public void addMovie() {
//		pane1.setVisible(false); 
//		pane2.setVisible(false);
//		pane3.setVisible(true);
//	}
	
	@SuppressWarnings("unused")
	public void buyMovie() throws SQLException {
		
		String Name=this.txtMovie.getText();
		
		Buy(Name);
}
	@SuppressWarnings("unused")
	private boolean Buy(String Name) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO movie_db1 (Name)" +"VALUES(?)";
	//	INSERT INTO movie_db (Name,Rating,Genre,Price)" +"VALUES(?,?,?,?)
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, Name);
           
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("Movie seleted!!!");
   		alert.setHeaderText("The movie has been bought");
   		alert.setContentText("You just bought a  movie, have fun!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	public buymovieController() {
		conn = new DBConnect();
		
	}

	public void logout() {
		 //System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("buy movie");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
}


