package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.model.AddressBook;

public interface IAddressBookService {
	public String getMessage(String name);
	public String postMessage(AddressBook addressBook);
	public String putMessage(String name);
	public String getWelcome();
	public AddressBook saveDataToRepo(AddressBookDTO addressBookDTO);

}
