package com.suranjay.infy.restwithmongo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.suranjay.infy.restwithmongo.repository.ContactFileGenRepository;
import com.suranjay.infy.restwithmongo.repository.ContactRepository;

@RestController
public class ExcelGenConroller {
	private static Logger LOGGER = Logger.getLogger(ExcelGenConroller.class);
	 @Autowired
	 private ContactFileGenRepository contactRepository;
	
	
	

}
