package controllers;

import java.sql.Connection;
import java.sql.ResultSet;

import application.Main;
import dao.DBConnect;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import models.CustomerModel;

public class CustomerController{
	
	@SuppressWarnings("unused")
	private CustomerModel cmd;
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView tblMovie;
	@FXML
	private TableColumn<CustomerModel, Integer> MovieID;
	@FXML
	private TableColumn<CustomerModel, String> Name;
	@FXML
	private TableColumn<CustomerModel, Double> Rating;
	@FXML
	private TableColumn<CustomerModel, String> Genre;
	@FXML
	private TableColumn<CustomerModel, Double> Price;
	
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;

	
	public CustomerController() {
		cmd=new CustomerModel();
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
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	public void BuyMovie(String Name) {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/buyMovie.fxml"));
				Main.stage.setTitle("Customer View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
	public void toMovie() {
		try {
		AnchorPane root;
		root = (AnchorPane)  FXMLLoader.load(getClass().getResource("/views/buyMovie.fxml"));
		
				Main.stage.setTitle("Buy Movie View");
			Scene scene = new Scene(root);
			Main.stage.setScene(scene);
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void viewData(String sql) {
		tblMovie = new TableView();
		DBConnect c = new DBConnect();
		data = FXCollections.observableArrayList();
		try {
			Connection conn = c.getConnection();
			// SQL FOR SELECTING DATA
			String SQL = sql;
			// ResultSet object
			ResultSet rs = conn.createStatement().executeQuery(SQL);

			/**********************************
			 * TABLE COLUMN ADDED DYNAMICALLY *
			 **********************************/
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {

	  		  // We are using non property style for making dynamic table
			  final int j = i;
			 TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));

			 /**
			 * Build an ObservableList for column headings as you iterate thru meta data
			 * setup callback Api for column retrievals, works with call method to return
			 * heading names
			 */
			col.setCellValueFactory(
			 new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
			 return new SimpleStringProperty(param.getValue().get(j).toString());
			}

			});
			// add each column name to tableview object
			tblMovie.getColumns().add(col);
			// display column names to console as they are added to table dynamically
			System.out.println("Column [" + i + "] added [" + rs.getMetaData().getColumnName(i + 1) + "]");
			}

			/********************************************
			 * Data added to ObservableList dynamically *
			 ********************************************/
			int ridx = 0; // track a row index to display to console added rows to table
			while (rs.next()) {
			 // Iterate Row
			 ObservableList<String> row = FXCollections.observableArrayList();
			 for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			  // Iterate Column, grab data
			  row.add(rs.getString(i));
			  }
			 System.out.println("Row [" + (ridx++) + "] added " + row);
			 data.add(row);
			 }
		                  // automatically adjust width of columns depending on their content
			tblMovie.setColumnResizePolicy((param) -> true);
			Platform.runLater(() -> customResize(tblMovie));

			// add data to tableview object
			tblMovie.setItems(data);

			 Scene secondScene = new Scene(tblMovie, 600, 400);
             
	           		Stage secondStage = new Stage();
	            		secondStage.setTitle("New Stage");
	            		secondStage.setScene(secondScene);
	             
	            		secondStage.show();
		
			Main.stage.setOnCloseRequest((WindowEvent event1) -> {
						
		   	 System.out.println("Main window closed");
				  
			});
			
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}

	}
	private Object customResize(@SuppressWarnings("rawtypes") TableView tblMovie) {
		// TODO Auto-generated method stub
		return null;
	}
	public void viewAccounts() {
		CustomerController cc = new CustomerController();
		//call method from DynamicTable class and pass some arbitrary query string
		cc.viewData("Select * from movie_db");
	}

	/*@FXML
	private void buyMovie() {
	    Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
	    if (selectedPerson != null) {
	        boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
	        if (okClicked) {
	            showPersonDetails(selectedPerson);
	        }

	    } else {
	        // Nothing selected.
	        Alert alert = new Alert(AlertType.WARNING);
	        alert.initOwner(mainApp.getPrimaryStage());
	        alert.setTitle("No Selection");
	        alert.setHeaderText("No Person Selected");
	        alert.setContentText("Please select a person in the table.");

	        alert.showAndWait();
	    }
	}*/
}

