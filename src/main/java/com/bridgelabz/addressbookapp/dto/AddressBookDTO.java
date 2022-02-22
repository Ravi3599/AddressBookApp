package com.bridgelabz.addressbookapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDTO {
	@NotEmpty(message="First name cant be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee firstName is Invalid")
	private String firstName;
	
	@NotEmpty(message="Last name cant be empty")
	@Pattern(regexp="^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Employee lastName is Invalid")
	private String lastName;
	
	@NotEmpty(message="Email cant be empty")
	@Pattern(regexp = "^[\\w+-]+(\\.[\\w-]+)*@[^_\\W]+(\\.[^_\\W]+)?(?=(\\.[^_\\W]{3,}$|\\.[a-zA-Z]{2}$)).*$", message = "Please enter a valid email id")
	private String email;
	
	@NotNull(message="Phone number cant be empty")
	//@Pattern(regexp = "^[0-9]{10}$", message = "Please enter a valid phone number")
	private long phoneNumber;
	
	@NotEmpty(message="city cant be empty")
	private String city;
	
	@NotEmpty(message="State cant be empty")
	private String state;
	
	@NotNull(message="Zip code cant be empty")
	//@Pattern(regexp = "^[0-9]{6}$", message = "Please enter a valid zip code")
	private Integer zip;
	
	public AddressBookDTO() {
		super();
	}

//	public AddressBookDTO(String firstName, String lastName, String email, long phoneNumber, String city, String state,
//			Integer zip) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.phoneNumber = phoneNumber;
//		this.city = city;
//		this.state = state;
//		this.zip = zip;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public long getPhoneNumber() {
//		return phoneNumber;
//	}
//
//	public void setPhoneNumber(long phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public Integer getZip() {
//		return zip;
//	}
//
//	public void setZip(Integer zip) {
//		this.zip = zip;
//	}
}