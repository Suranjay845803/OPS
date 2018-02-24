package com.suranjay.infy.restwithmongo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suranjay.infy.restwithmongo.beans.Contact;
import com.suranjay.infy.restwithmongo.repository.ContactRepository;

@RestController
public class ContactController {
	private static Logger LOGGER = Logger.getLogger(ContactController.class);
	 @Autowired
	 private ContactRepository contactRepository;
	 @RequestMapping(value="/contacts",method=RequestMethod.GET)
	    public Iterable<Contact> contact() {
		    LOGGER.info("inside find all");
	        return contactRepository.findAll();
	    }

	    @RequestMapping(method=RequestMethod.POST, value="/contacts")
	    public Contact save(@RequestBody Contact contact) {
	    	LOGGER.info("inside add contact");
	        contactRepository.save(contact);
	        LOGGER.info("contact added");
	        return contact;
	    }

	    @RequestMapping(method=RequestMethod.GET, value="/contacts/{id}")
	    public Contact show(@PathVariable String id) {
	    	LOGGER.info("inside find by id ");
	        return contactRepository.findOne(id);
	    }

	    @RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
	    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
	    	LOGGER.info("inside update ");
	        Contact c = contactRepository.findOne(id);
	        if(contact.getName() != null)
	            c.setName(contact.getName());
	        if(contact.getAddress() != null)
	            c.setAddress(contact.getAddress());
	        if(contact.getCity() != null)
	            c.setCity(contact.getCity());
	        if(contact.getPhone() != null)
	            c.setPhone(contact.getPhone());
	        if(contact.getEmail() != null)
	            c.setEmail(contact.getEmail());
	        contactRepository.save(c);
	        return contact;
	    }
	    @RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
	    public String delete(@PathVariable String id) {
	    	LOGGER.info("inside delete ");
	        Contact contact = contactRepository.findOne(id);
	        contactRepository.delete(contact);

	        return "";
	    }
	    @RequestMapping(value="/delcontact",method=RequestMethod.DELETE)
	    public String deleteobj(@RequestBody Contact contact){
	    	LOGGER.info("inside full delete");
	    	contactRepository.delete(contact);
	    	LOGGER.info("fulldelete completed");
			return "";
	    	
	    }
}
