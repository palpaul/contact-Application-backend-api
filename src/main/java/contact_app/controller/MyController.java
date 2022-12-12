package contact_app.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contact_app.entity.Contact;
import contact_app.service.ContactService;
import contact_app.serviceImpl.ContactServiceImpl;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
public class MyController {
	
//	@Autowired
//	private ContactService contactService;
	@Autowired
	private ContactServiceImpl contactServiceImpl;
	//home page
	
	
	@GetMapping("/welcome")
	public String sayWelcome() {
		return "Hey welcome to contact App using springboot and mysql db";	
	}

	
	@GetMapping("/wish")
	public String sayWish() {
		return "ALl the Best";	
	}
	
	//get all contacts
	
	@GetMapping("/showallcontacts")
	public List<Contact> getAllContacts() {
		return this.contactServiceImpl.getAllContacts();
	}
	
	//get contacts by id
	@GetMapping("/showcontact/{contactId}")
	public Contact getContactById(@PathVariable long contactId) {
		return this.contactServiceImpl.getContactById(contactId);
	}
//	
	//get contacts by name
//	@CrossOrigin(origins="*",allowedHeaders="*")
//	@GetMapping("/showcontactByname/{contactName}")
//	public Contact getContactByName(@PathVariable String contactName) {
//		return this.contactServiceImpl.getContactByName(contactName);
//	}
	
	
	//add
	@PostMapping("/savectn")
	public Contact saveContact(@RequestBody Contact contact	){
		return this.contactServiceImpl.saveContact(contact);
	}
	
	@PostMapping("/saveallctn")
	public List<Contact> saveAllContacts(@RequestBody List<Contact> contact	){
		return this.contactServiceImpl.saveAllContacts(contact);
	}
	
	//update
	@PutMapping("/updatectn")
	public Contact updateContact(@RequestBody Contact contact) {
		return this.contactServiceImpl.updateContact(contact);
		
	}
	//delete
	@DeleteMapping("/deletectn/{contId}")
	public String deleteContact(@PathVariable long contactId) {
		return this.contactServiceImpl.deleteContact(contactId);
		
	}
	
	
	

}
