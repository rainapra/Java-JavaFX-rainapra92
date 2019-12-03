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

public class AddMovieController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField txtName;
	@FXML
	private TextField txtRating;
	@FXML
	private TextField txtGenre;
	@FXML
	private TextField txtPrice;
	
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
	public void addMovies() throws SQLException {
		
		String mName=this.txtName.getText();
		String rating=this.txtRating.getText();
		String genre=this.txtGenre.getText();
		String price=this.txtPrice.getText();
		AddMovie(mName,rating,genre,price);
}
	@SuppressWarnings("unused")
	private boolean AddMovie(String mName, String rating, String genre, String price) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO movie_db (Name,Rating,Genre,Price)" +"VALUES(?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, mName);
           stmt.setString(2, rating);
           stmt.setString(3, genre);          
           stmt.setString(4, price);
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("New Movie Added!!!");
   		alert.setHeaderText("Add New Movie");
   		alert.setContentText("You just added a new movie!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	public AddMovieController() {
		conn = new DBConnect();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("You want to add new movie?");
		alert.setHeaderText("Add New Movie");
		alert.setContentText("Select OK to add new movie!!!");
		alert.showAndWait();
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

