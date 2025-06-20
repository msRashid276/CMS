package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	@Override
	public void update(Contact contact) throws SQLException {


		String sql="UPDATE contacts SET first_name=?, last_name=?,email=?,phone_number= ? WHERE id =?";
		
		
		try(Connection con =getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
					stmt.setString(1,contact.getFirstName());
					stmt.setString(2, contact.getLastName());
					stmt.setString(3, contact.getEmail());
					stmt.setString(4, contact.getPhoneNumber());
					stmt.setInt(5, contact.getId());
				
				}
				
				
				
				
				
				
		
	}

	@Override
	public void delete(int id) throws SQLException {
      
		String sql ="DELETE FROM contacts WHERE id=?";
		
		try(Connection con =getConnection();
				PreparedStatement stmt =con.prepareStatement(sql)){
			stmt.setInt(1, id);
			
			int rowsAffected =stmt.executeUpdate();
			if(rowsAffected>0) {
				System.out.println("Contact with ID"+id+"delete successfully");
				
			}
			else {
				System.out.println(" No Contact with ID"+id+" to delete ");
				
			}
		}

		
	}

	  @Override
	    public Contact findById(int id) throws SQLException {
	        String sql = "SELECT id, first_name, last_name, email, phone_number FROM contacts WHERE id = ?";
	        Contact contact = null;

	        try (Connection con = getConnection();
	             PreparedStatement stmt = con.prepareStatement(sql)) {

	            stmt.setInt(1, id);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {
	                    contact = new Contact();
	                    contact.setId(rs.getInt("id"));
	                    contact.setFirstName(rs.getString("first_name"));
	                contact.setLastName(rs.getString("last_name"));
	                    contact.setEmail(rs.getString("email"));
	                    contact.setPhoneNumber(rs.getString("phone_number"));
	                }
	            }
	        }
	        return contact;
	    }
}
