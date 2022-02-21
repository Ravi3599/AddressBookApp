package com.bridgelabz.addressbookapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bridgelabz.addressbookapp.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{

	@Query(value="select * from address_book where first_name = :first_name",nativeQuery=true)
	public List<AddressBook> findByFirstName(@Param(value="first_name")String firstName);
	
	@Query(value="select * from address_book ",nativeQuery=true)
	public List<AddressBook> findAllData();
}
