package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.AddressBookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

//Created controller class so we can perform api calls
@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	
	//Autowired IAddressBookService interface so we can inject its dependency here
	@Autowired
	private IAddressBookService service;
	
	//Ability to get welcome message
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcome(){
		String message = service.getWelcome();
		return new ResponseEntity(message,HttpStatus.OK);
	}
	//Ability to store a address book record to repo
	@PostMapping("/create")
	public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO){
		String entity = service.saveDataToRepo(addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Address Book Record created successfully",entity);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	//Ability to retrieve all data from repo
	@GetMapping("/get")
	public ResponseEntity<String> getDataFromRepo(){
		List<AddressBook> newAddressBook = service.getRecord();
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	//Ability to retrive all data by token
	@GetMapping(value = "/retrive/{token}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable String token)
	{
		List<AddressBook> entity = service.getAddressBookData(token);
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	//Ability to get record by id
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getRecordFromRepoByID(@PathVariable Integer id) throws AddressBookException{
		AddressBook newAddressBook = service.getRecordById(id);
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	//Ability to update record for particular id
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRecordById(@PathVariable Integer id,@Valid @RequestBody AddressBookDTO addressBookDTO){
		AddressBook newAddressBook = service.updateRecordById(id,addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	//Ability to delete record for particular id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRecordById(@PathVariable Integer id){
		ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",service.deleteRecordById(id));
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	//Ability to get record by city
	@GetMapping("/getbycity/{city}")
	public ResponseEntity<String> getRecordFromRepoByCity(@PathVariable String city) throws AddressBookException{
		List<AddressBook> newAddressBook = service.getRecordByCity(city);
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular city retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
}