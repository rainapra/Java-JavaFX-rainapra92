package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DBConnect;

public class LoginModel extends DBConnect{
	private Boolean user_type;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean isAdmin() {
		return user_type;
	}
	public void setAdmin(Boolean user_type) {
		this.user_type = user_type;
	}
	
	public Boolean getCredentials(String username, String password){
           
           String query = "SELECT * FROM m_user WHERE username = ? and password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
                if(rs.next()) { 
                	setId(rs.getInt("id"));
                	setAdmin(rs.getBoolean("user_type"));
                	return true;
               	}
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
	       return false;
    }
}
