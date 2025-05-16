package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Contact;

public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	@Override
	public void save(Contact contact) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO contacts(first_name,last_name,email,phone_number) VALUES(?,?,?,?)";
		
		try(Connection con =getConnection();
				
				PreparedStatement stmt =con.prepareStatement(sql)
				
				){
			stmt.setString(1, contact.getFirstName());
			stmt.setString(2, contact.getLastName());
			stmt.setString(3, contact.getEmail());
			stmt.setString(4,contact.getPhoneNumber());
			stmt.executeUpdate();
			
		}
		
	}

}
