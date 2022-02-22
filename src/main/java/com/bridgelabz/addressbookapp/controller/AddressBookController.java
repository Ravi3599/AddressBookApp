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

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@Autowired
	IAddressBookService service;
	//Ability to get simple welcome message with name through request parameter
	@GetMapping("/getMessage")
	public ResponseEntity<String> getMessage(@RequestParam String name){
		String message = service.getMessage(name);
		return new ResponseEntity(message,HttpStatus.OK);
	}
	//Ability to get simple "hello" message with firstName and lastName
	@PostMapping("/postMessage")
	public ResponseEntity<String> postMessage(@RequestBody AddressBook addressBook){
		String message = service.postMessage(addressBook);
		return new ResponseEntity(message,HttpStatus.OK);
	}
	//Ability to get simple "hi" message with name of person through pathvariable
	@GetMapping("/putMessage/{name}")
	public ResponseEntity<String> putMessage(@PathVariable String name){
		String message = service.putMessage(name);
		return new ResponseEntity(message,HttpStatus.OK);
	}
	//Ability to get welcome message
	@GetMapping("/welcome")
	public ResponseEntity<String> getWelcome(){
		String message = service.getWelcome();
		return new ResponseEntity(message,HttpStatus.OK);
	}
	//Ability to store a address book record to repo
	@PostMapping("/create")
	public ResponseEntity<String> saveDataToRepo(@Valid @RequestBody AddressBookDTO addressBookDTO){
		AddressBook newAddressBook = service.saveDataToRepo(addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Address Book Record created successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	//Ability to retrieve all data from repo
	@GetMapping("/get")
	public ResponseEntity<String> getDataFromRepo(){
		List<AddressBook> newAddressBook = service.getRecord();
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
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
}