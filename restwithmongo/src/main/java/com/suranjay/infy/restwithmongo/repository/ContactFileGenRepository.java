package com.suranjay.infy.restwithmongo.repository;

import org.springframework.data.repository.CrudRepository;

import com.suranjay.infy.restwithmongo.beans.Contact;

public interface ContactFileGenRepository extends CrudRepository<Contact, String> {
	
	
}
