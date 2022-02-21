package com.bridgelabz.addressbookapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;

@Entity
public class AddressBook {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;
	private String city;
	private String state;
	private Integer zip;
	
	
	public AddressBook() {
		super();
	}
	public AddressBook(Integer id, String firstName, String lastName, String email, long phoneNumber, String city,
			String state, Integer zip) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public AddressBook(AddressBookDTO addressBookDTO) {
		this.firstName = addressBookDTO.getFirstName();
		this.lastName = addressBookDTO.getLastName();
		this.email = addressBookDTO.getEmail();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
		this.city = addressBookDTO.getCity();
		this.state = addressBookDTO.getCity();
		this.zip = addressBookDTO.getZip();
	}
	public AddressBook(Integer id,AddressBookDTO addressBookDTO) {
		this.id=id;
		this.firstName = addressBookDTO.getFirstName();
		this.lastName = addressBookDTO.getLastName();
		this.email = addressBookDTO.getEmail();
		this.phoneNumber = addressBookDTO.getPhoneNumber();
		this.city = addressBookDTO.getCity();
		this.state = addressBookDTO.getCity();
		this.zip = addressBookDTO.getZip();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
}