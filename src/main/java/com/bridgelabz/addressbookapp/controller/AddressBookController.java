package com.bridgelabz.addressbookapp.controller;

import java.util.List;
import java.util.Optional;

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
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@Autowired
	IAddressBookService service;
	
	@GetMapping("/getMessage")
	public ResponseEntity<String> getMessage(@RequestParam String name){
		String message = service.getMessage(name);
		return new ResponseEntity(message,HttpStatus.OK);
	}
	@PostMapping("/postMessage")
	public ResponseEntity<String> postMessage(@RequestBody AddressBook addressBook){
		String message = service.postMessage(addressBook);
		return new ResponseEntity(message,HttpStatus.OK);
	}
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
	public ResponseEntity<String> saveDataToRepo(@RequestBody AddressBookDTO addressBookDTO){
		AddressBook newAddressBook = service.saveDataToRepo(addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Address Book Record created successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<String> getDataFromRepo(){
		List<AddressBook> newAddressBook = service.getRecord();
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<String> getRecordFromRepoByID(@PathVariable Integer id){
		Optional<AddressBook> newAddressBook = service.getRecordById(id);
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular id retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	@GetMapping("/get/{firstName}")
	public ResponseEntity<String> getRecordFromRepoByFirstName(@PathVariable String firstName){
		List<AddressBook> newAddressBook = service.getRecordByFirstName(firstName);
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular firstName retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getAll")
	public ResponseEntity<String> getRecordFromRepoByName(){
		List<AddressBook> newAddressBook = service.getRecordByName();
		ResponseDTO dto = new ResponseDTO("Address Book Record for particular name retrieved successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateRecordById(@PathVariable Integer id,@RequestBody AddressBookDTO addressBookDTO){
		AddressBook newAddressBook = service.updateRecordById(id,addressBookDTO);
		ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",newAddressBook);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRecordById(@PathVariable Integer id){
		ResponseDTO dto = new ResponseDTO("Address Book Record updated successfully",service.deleteRecordById(id));
		return new ResponseEntity(dto,HttpStatus.OK);
	}
}
