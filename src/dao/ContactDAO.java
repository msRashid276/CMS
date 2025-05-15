package dao;

import java.sql.SQLException;

import model.Contact;

public interface ContactDAO {
	void save (Contact contact) throws SQLException;
	

}
