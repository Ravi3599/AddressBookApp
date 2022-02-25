package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

//Created interface for all service methods so we can achieve abstraction
public interface IAddressBookService {
	public String getWelcome();
	public String saveDataToRepo(AddressBookDTO addressBookDTO);
	public AddressBook getRecordById(Integer id);
	public List<AddressBook> getRecord();
	public List<AddressBook> getAddressBookData(String token);
	public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO);
	public String deleteRecordById(Integer id);
	public List<AddressBook> getRecordByCity(String city);
}