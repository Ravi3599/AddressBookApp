package com.bridgelabz.addressbookapp.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.model.AddressBook;

@Service
public class AddressBookService {

	public String getMessage(String name) {
		return "Welcome "+name;
	}
	public String postMessage(AddressBook addressBook) {
		return "Hello "+addressBook.getFirstName()+" "+addressBook.getLastName();
	}
	public String putMessage(String name) {
		 return "How are you, "+name;
	}
	

}
