package com.suranjay.infy.restwithmongo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suranjay.infy.restwithmongo.beans.Contact;
@Repository
public interface ContactRepository extends CrudRepository<Contact, String> {
	 @Override
	  public  Contact findOne(String id);

	    @Override
	 public void delete(Contact deleted);
}
