package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.User;
import dao.DBConnect;

public abstract class CustomerModel extends DBConnect {
	    int CustomerID;   
		String Name;
	    String Address;
	    String Gender;
	    double Phone; 
	    int Age;

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

		public List<CustomerModel> getAccounts(int cid) {
			List<CustomerModel> accounts = new ArrayList<>();
			String query = 
	       "SELECT  Name, Rating, Price FROM pr_movie;";
			try (PreparedStatement statement = 
	          connection.prepareStatement(query)) {
				statement.setInt(1, cid);
				ResultSet resultSet = statement.executeQuery();
				
	while (resultSet.next()) {
		CustomerModel account = new CustomerModel();
		     // grab data by table field name into CustomerModel account object
				   account.setID(resultSet.getInt("id"));
				   account.setName(resultSet.getDouble("name"));
				   
				   accounts.add(account); // add account data to arraylist
				}
			} catch (SQLException e) {
				System.out.println("Error fetching Records: " + e);
			}
			return accounts; // return arraylist
		}

//	public setCustomerID()
//	{
//		
//	}

}
