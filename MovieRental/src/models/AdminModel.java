package models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBConnect;

public abstract class AdminModel extends DBConnect{

	    int AdminID;   
		String Name;
	    String Gender;
	  
	@SuppressWarnings("unused")
	public AdminModel(String mName, Float rating, String genre, Float price)
	{
		String query = "INSERT INTO movie_db (Name,Rating,Genre,Price) VALUES(?,?,?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)) {
           stmt.setString(1, mName);
           stmt.setFloat(2, rating);
           stmt.setString(3, genre);          
           stmt.setFloat(4, price);
           int count = stmt.executeUpdate();
           return;            
         }catch (SQLException e) {
        	e.printStackTrace();   
         }
       return;
	}
	public void deleteMovie()
	{
		
	}
	public void updateMovie()
	{
		
	}
	public void submitMovie()
	{
		
	}
}

