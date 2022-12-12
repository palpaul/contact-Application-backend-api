package contact_app.service;

import java.util.List;

import contact_app.entity.ContactEntity;

public interface MyContactService {
	
	public String saveContact(ContactEntity ctn);
	public List<ContactEntity> getAllContacts();
	public ContactEntity getContactById(long ctnid);
	public String UpdateContact(ContactEntity ctn);
	public String deleteContactById(long ctnid);
}
