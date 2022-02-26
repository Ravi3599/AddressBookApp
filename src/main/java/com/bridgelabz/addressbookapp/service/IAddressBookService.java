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
	public AddressBook getRecordByToken(String token);
	public List<AddressBook> getRecord();
	public List<AddressBook> getAddressBookData(String token);
	public AddressBook updateRecordById(Integer id, AddressBookDTO addressBookDTO);
	public AddressBook updateRecordByToken(String token, AddressBookDTO addressBookDTO);
	public AddressBook deleteRecordById(Integer id);
	public AddressBook deleteRecordByToken(String token);
	public List<AddressBook> getRecordByCity(String city);
}