package model;

public class Contact extends Person {
	
	private int id;
	private String email;
	private String phoneNumber;

	public Contact(String firstName, String lastName,String email,String phoneNumber) {
		super(firstName, lastName);
		this.id=id;
		this.id=id;
		this.phoneNumber=phoneNumber;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
