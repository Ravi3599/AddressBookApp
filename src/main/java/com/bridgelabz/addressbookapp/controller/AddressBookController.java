package com.bridgelabz.addressbookapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {
	
	@GetMapping("/getMessage")
	public ResponseEntity<String> getMessage(@RequestParam String name){
		String message = "Welcome "+name+"!";
		return new ResponseEntity(message,HttpStatus.OK);
	}
	@PostMapping("/postMessage/{fName}")
	public ResponseEntity<String> postMessage(@PathVariable String fName,@RequestParam String lName){
		String message = "Hello "+fName+""+lName;
		return new ResponseEntity(message,HttpStatus.OK);
	}
	@PutMapping("/putMessage/{name}")
	public ResponseEntity<String> putMessage(@PathVariable String name){
		String message = "How are you, "+name;
		return new ResponseEntity(message,HttpStatus.OK);
	}
}
