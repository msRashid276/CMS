package service;

import dto.ContactDTO;

import java.sql.SQLException;
import java.util.List;

import dao.ContactDAO;
import dao.ContactDAOImpl;
import model.Contact;

public class ContactServiceImp implements ContactService {
	private ContactDAO contactDAO = new ContactDAOImpl();

	@Override
	public void addContact(ContactDTO contactDto)  throws SQLException{

       Contact contact=new Contact(0,contactDto.getFirstName(),
    		   contactDto.getLastName(),
    		   contactDto.getEmail(),
    		   contactDto.getPhoneNumber()
    		   );
       contactDAO.save(contact);
		
	}

	@Override
	public ContactDTO getContactById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactDTO> getAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateContact(int id, ContactDTO updatedContact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContact(int id) {
		// TODO Auto-generated method stub
		
	}
	
	





	



}

