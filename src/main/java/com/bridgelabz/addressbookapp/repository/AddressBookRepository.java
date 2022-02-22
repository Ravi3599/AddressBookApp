package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bridgelabz.addressbookapp.model.AddressBook;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer>{
}
