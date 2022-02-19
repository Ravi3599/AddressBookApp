package com.bridgelabz.addressbookapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.service.AddressBookService;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	@Autowired
	AddressBookService service;
	
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
	@PutMapping("/putMessage/{name}")
	public ResponseEntity<String> putMessage(@PathVariable String name){
		String message = service.putMessage(name);
		return new ResponseEntity(message,HttpStatus.OK);
	}
}
