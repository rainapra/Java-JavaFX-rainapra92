package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import dao.DBConnect;
import javafx.scene.control.TableColumn;

public class CustomerModel extends DBConnect {
//	    int customerID;   
//		String name;
//	    String address;
//	    String gender;
//	    double phone; 
//	    int age;
	    

		int mID;
		public int getmID() {
			return mID;
		}

		public void setmID(int mID) {
			this.mID = mID;
		}

		public String getMname() {
			return mname;
		}

		public void setMname(String mname) {
			this.mname = mname;
		}

		public double getMrating() {
			return mrating;
		}

		public void setMrating(double mrating) {
			this.mrating = mrating;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		String mname;
	    double mrating;
	    String genre;
	    double price;
		// Declare DB objects
		DBConnect conn = null;
		Statement stmt = null;

		public CustomerModel() { conn = new DBConnect(); }

//	public void insertRecord(int CustomerID, String Name, String Address, String Gender, Double Phone, int Age) {
//
//			try {
//				setCustomerID (CustomerID);
//				// Execute a query
//				System.out.println("Inserting record into the table...");
//				stmt = conn.getConnection().createStatement();
//				String sql = null;
//
//				// Include data to the database table
//
//				sql = " insert into pra_customer(CustomerID, Name, Address, Gender, Phone, Age) values ('" + CustomerID + "', '" + Name + "','" + Address + "','" + Gender + "','" + Phone + "','" + Age + "')";
//
//				stmt.executeUpdate(sql);
//				conn.getConnection().close();
//
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}

		public List<CustomerModel> getAccounts() {
			List<CustomerModel> accounts = new ArrayList<>();
			String query = "SELECT * FROM movie_db";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setInt(1, mID);
				statement.setString(2, mname);
				statement.setDouble(3, mrating);
				statement.setString(4, genre);
				statement.setDouble(5, price);
				ResultSet resultSet = statement.executeQuery();
				
				while (resultSet.next()) {
					CustomerModel cm = new CustomerModel();
		     // grab data by table field name into CustomerModel account object
					cm.setmID(resultSet.getInt("MovieID"));
					cm.setMname(resultSet.getString("Name"));
					cm.setMrating(resultSet.getDouble("Rating"));
					cm.setGenre(resultSet.getString("Genre"));
					cm.setPrice(resultSet.getDouble("Price"));
				   
				   accounts.add(cm); // add account data to arraylist
				   System.out.println(mID+"   "+mname+"    "+mrating+" "+genre+" "+price);
				}
			} catch (SQLException e) {
				System.out.println("Error in fetching Records: " + e);
			}
			return accounts; // return arraylist
		}
//	public setCustomerID()
//	{
//		
//	}

}

