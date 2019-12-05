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

public class DeleteMovieController extends DBConnect {
	@FXML
	private Pane pane1;
	@FXML
	private TextField txtName;
	
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
	public void delMovies() throws SQLException {
		
		String Name=this.txtName.getText();
		
		DeleteMovie(Name);
}
	@SuppressWarnings("unused")
	private boolean DeleteMovie(String Name) {
		// TODO Auto-generated method stub
		String query = "delete from movie_db where Name = ?";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, Name);
           
           boolean rs = stmt.execute();
           Alert alert = new Alert(AlertType.INFORMATION);
   		alert.setTitle("Movie deleted!!!");
   		alert.setHeaderText("The movie has been deleted");
   		alert.setContentText("You just deleted a  movie!!!");
   		alert.showAndWait();
           return true;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return false;
	}
	
	public DeleteMovieController() {
		conn = new DBConnect();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Movie deleted");
		alert.setHeaderText("Click ok to proceed");
		alert.setContentText("Select OK to delete a movie!!!");
		alert.showAndWait();
	}

	public void cancel() {
		 //System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/AdminView.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Admin");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
}

