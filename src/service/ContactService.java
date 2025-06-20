package service;

import java.sql.SQLException;

import java.util.List;
import dto.ContactDTO;

public interface ContactService {
	void addContact(ContactDTO contactDto) throws SQLException;

	 ContactDTO getContactById(int id);

	

	List<ContactDTO> getAllContacts();

	void updateContact(int id, ContactDTO updatedContact);

	void deleteContact(int id);

	

}
