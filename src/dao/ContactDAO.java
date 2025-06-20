package dao;

import java.sql.SQLException;

import model.Contact;

public interface ContactDAO {
	void save (Contact contact) throws SQLException;
	void update (Contact contact) throws SQLException;
	void delete(int id) throws SQLException;
Contact  findById(int id) throws SQLException;
	

}
