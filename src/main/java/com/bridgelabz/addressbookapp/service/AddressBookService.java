package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService{
	//Autowired repository class so we can inject its dependecy here
	@Autowired
	AddressBookRepository repo;
	
	//Created service method which serves controller api to return welcome message
	public String getWelcome() {
		return "Welcome to Address Book !";
	}
	//Created service method which serves controller api to post data 
	public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO) {
		AddressBook newAddressBook = new AddressBook(addressBookDTO);
		repo.save(newAddressBook);
		log.info("Address Book Data got saved");
		return newAddressBook;
	}
	//Created service method which serves controller api to get record by id 
	public AddressBook getRecordById(Integer id) {
//		List<AddressBook> addressList = repo.findAll();
//		AddressBook newAddressBook = addressList.stream().filter(addressData->addressData.getId()==id)
//				.findFirst()
//				.orElseThrow(()->new AddressBookException("Particular address book details not found"));
		Optional<AddressBook> newAddressBook = repo.findById(id);
		if(newAddressBook.isEmpty()) {
			log.warn("Unable to find address book details for given id: "+id);
			throw new AddressBookException("Address Book Details for id not found");
		}
		return newAddressBook.get();
	}
	//Created service method which serves controller api to retrieve all records 
	public List<AddressBook> getRecord(){
		List<AddressBook> addressBook = repo.findAll();
		log.info("Found all records in Address Book");
		return addressBook;
	}
	//Created service method which serves controller api to update record by id 
	public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO) {
		Optional<AddressBook> addressBook = repo.findById(id);
		if(addressBook.isEmpty()) {
			throw new AddressBookException("Address Book Details for id not found");
		}
		AddressBook newBook = new AddressBook(id,addressBookDTO);
		repo.save(newBook);
		log.info("Address Book Data got updated for id: "+id);
		return newBook;
	}
	//Created service method which serves controller api to delete record by id 
	public String deleteRecordById(Integer id) {
//		List<AddressBook> addressList = repo.findAll();
//		AddressBook newAddressBook = addressList.stream().filter(addressData->addressData.getId()==id)
//				.findFirst()
//				.orElseThrow(()->new AddressBookException("Particular address book details not found"));
//		repo.delete(newAddressBook);
		Optional<AddressBook> newAddressBook = repo.findById(id);
		if(newAddressBook.isEmpty()) {
			log.warn("Unable to find address book details for given id: "+id);
			throw new AddressBookException("Address Book Details not found");
		}
		else {
			repo.deleteById(id);
		}
		return null;	
	}
	//Created service method which serves controller api to get record by city
	public List<AddressBook> getRecordByCity(String city) {
//		List<AddressBook> addressList = repo.findAll();
//		AddressBook newAddressBook = addressList.stream().filter(addressData->addressData.getCity()==city)
//									.findFirst()
//									.orElseThrow(()->new AddressBookException("Particular address book details not found"));
		List<AddressBook> newAddressBook = repo.findByCity(city);
		if(newAddressBook.isEmpty()) {
			log.warn("Unable to find address book details for given city: "+city);
			throw new AddressBookException("Address Book Record not Found");
		}
		return newAddressBook;
	}
}