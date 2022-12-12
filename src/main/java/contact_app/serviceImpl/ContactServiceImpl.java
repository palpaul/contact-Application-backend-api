package contact_app.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contact_app.dao.ContactDao;
import contact_app.entity.Contact;
import contact_app.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	@Autowired
	private ContactDao contactDao;
	
	//save contact
	@Override
	public Contact saveContact(Contact contact) {
		return contactDao.save(contact);

	}
	//save all
		@Override
		public List<Contact> saveAllContacts(List<Contact> contacts) {
			return contactDao.saveAll(contacts);
		}
		
		
		//ind by ID contact 
		@Override
		public Contact getContactById(Long contactId) {
			return contactDao.findById(contactId).orElse(null);
		}

		//find by name contact
//		@Override
//		public Contact getContactByName(String  findbyName) {
//			return contactDao.findbyName(findbyName);
//		}
		
	//find all contact
	@Override
	public List<Contact> getAllContacts() {
		return contactDao.findAll();
	}	
	
	//update contact
	@Override
	public Contact updateContact(Contact contact) {
	Contact existingContact = contactDao.findById(contact.getContactId()).orElse(null);
		existingContact.setContactName(contact.getContactName());
		existingContact.setContactEmail(contact.getContactEmail());
		existingContact.setContactNum(contact.getContactNum());
		return contactDao.save(existingContact);			
	}
	
	//delete contact
	@Override
	public String deleteContact(Long contactId) {
		 contactDao.deleteById(contactId);
		return "Contact ID : " +contactId + " is deleted";
	}
//	@Override
//	public Contact updateContact(Contact contact) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	


}
