package com.bridgelabz.addressbookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bridgelabz.addressbookapp.model.AddressBook;

//Created AddressBookRepository extending JpaRepository so we can perform CRUD as well as can implement custom query methods
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{

	@Query(value="select * from address_book where city =:city",nativeQuery=true)
	public List<AddressBook> findByCity(String city);	
}
