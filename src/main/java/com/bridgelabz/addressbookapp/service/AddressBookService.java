package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<AddressBook> getRecordById(Integer id) {
		Optional<AddressBook> addressBook = repo.findById(id);
		return addressBook;
	}
	public List<AddressBook> getRecord(){
		return repo.findAll();
	}
	public List<AddressBook> getRecordByFirstName(String firstName){
		List<AddressBook> list=repo.findByFirstName(firstName);
		return list;
	}
	public List<AddressBook> getRecordByName(){
		return repo.findAllData();
	}
	public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
		AddressBook newBook = new AddressBook(id,addressBookDTO);
		repo.save(newBook);
		return newBook;
	}
	public String deleteRecordById(Integer id) {
		repo.deleteById(id);
		return null;
	}

	

}