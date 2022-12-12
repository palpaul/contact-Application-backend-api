package contact_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import contact_app.entity.ContactEntity;
import contact_app.serviceImpl.MyContactServiceImpl;

@CrossOrigin
@RestController
public class MyContactController {
	@Autowired
	private MyContactServiceImpl mycontactServiceImpl;
	@PostMapping("/savecontact")
	public String saveContact(@RequestBody ContactEntity ctn) {
		return mycontactServiceImpl.saveContact(ctn);
	}
	
	@GetMapping("/getallcontacts")
	public List<ContactEntity> getAllContacts(){
		return mycontactServiceImpl.getAllContacts();
		
	}
	
	@GetMapping("/getcontact/{id}")
	public ContactEntity getContactById(@PathVariable long id) {
		return mycontactServiceImpl.getContactById(id);
	}
	
	@PutMapping("/updatecontact")
	public String updateContact(@RequestBody ContactEntity ctn) {
		return mycontactServiceImpl.UpdateContact(ctn);
	}
	@DeleteMapping("/deletecontact/{id}")
	public String deleteContactById(@PathVariable long id) {
		return mycontactServiceImpl.deleteContactById(id);
	}

}
