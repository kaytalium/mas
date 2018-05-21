package cw.heslop.mas.objects;
import java.util.Date;

public class Person {

	private int personId;
	private String title = null;
	private String firstname = null;
	private String lastname = null;
	private String contact = null;
	private String email = null;
	private String dateOfBirth = null;
	private String gender = null;
	private String address = null;
	private String city = null;
	private String country = null;
	
	
	public Person() {
		// TODO Auto-generated constructor stub
	}


	public Person(String title, String firstname, String lastname, String contact, String email, String dateOfBirth,
			String gender, String address, String city, String country) {
		this.title = title;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.city = city;
		this.country = country;
	}


	public int getPersonId() {
		return personId;
	}


	public void setPersonId(int personId) {
		this.personId = personId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	public String insertQuery() {
		return String.format("INSERT INTO person (`title`,`first_name`,`last_name`,`email`,`contact`,`gender`,`address`,`city`,`country`,`dob`) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')",
				this.getTitle(),
				this.getFirstname(),
				this.getLastname(),
				this.getEmail(),
				this.getContact(),
				this.getGender(),
				this.getAddress(),
				this.getCity(),
				this.getCountry(),
				this.getDateOfBirth());
	}
	
	public String updateQuery() {
		return String.format("UPDATE person set title='%s', first_name='%s', last_name='%s', email='%s', contact='%s', gender='%s', address='%s', city='%s', country='%s', dob='%s' WHERE id='%s'", 
				this.getTitle(),
				this.getFirstname(),
				this.getLastname(),
				this.getEmail(),
				this.getContact(),
				this.getGender(),
				this.getAddress(),
				this.getCity(),
				this.getCountry(),
				this.getDateOfBirth(),
				this.getPersonId()
				);
	}

}
