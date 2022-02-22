package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

public interface IAddressBookService {
	public String getMessage(String name);
	public String postMessage(AddressBook addressBook);
	public String putMessage(String name);
	public String getWelcome();
	public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO);
	public AddressBook getRecordById(Integer id);
	public List<AddressBook> getRecord();
	public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO);
	public String deleteRecordById(Integer id);
	public List<AddressBook> getRecordByCity(String city);
}