package contact_app.service;

import java.util.List;

import contact_app.entity.Contact;
public interface ContactService {
	
	public Contact saveContact(Contact contact);
	public List<Contact> saveAllContacts(List<Contact> contacts);
	
	public List<Contact> getAllContacts();
	public Contact getContactById(Long contactId);
//	public Contact getContactByName(String findbyName);
	
	public Contact updateContact(Contact contact);
	
	
	public String deleteContact(Long contactId);
	
	
	
}
