package com.bridgelabz.addressbookapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService{
	@Autowired
	AddressBookRepository repo;

	public String getMessage(String name) {
		return "Welcome "+name;
	}
	public String postMessage(AddressBook addressBook) {
		return "Hello "+addressBook.getFirstName()+" "+addressBook.getLastName();
	}
	public String putMessage(String name) {
		 return "How are you, "+name;
	}
	public String getWelcome() {
		return "Welcome to Address Book !";
	}
	public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO) {
		AddressBook newAddressBook = new AddressBook(addressBookDTO);
		repo.save(newAddressBook);
		return newAddressBook;
	}
	

}
