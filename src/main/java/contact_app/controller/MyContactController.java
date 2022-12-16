package contact_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contact_app.entity.ContactEntity;
import contact_app.serviceImpl.MyContactServiceImpl;

@CrossOrigin
@RestController
public class MyContactController {
	@Autowired
	private MyContactServiceImpl mycontactServiceImpl;
	@PostMapping("/contact")
	public String saveContact(@RequestBody ContactEntity ctn) {
		String status = mycontactServiceImpl.saveContact(ctn);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<ContactEntity> getAllContacts(){
		return mycontactServiceImpl.getAllContacts();
		
	}
	
	@GetMapping("/contact/{id}")
	public ContactEntity getContactById(@PathVariable long id) {
		return mycontactServiceImpl.getContactById(id);
	}
	
	@PutMapping("/contact")
	public String updateContact(@RequestBody ContactEntity ctn) {
		return mycontactServiceImpl.UpdateContact(ctn);
	}
	@DeleteMapping("/contact/{id}")
	public String deleteContactById(@PathVariable long id) {
		return mycontactServiceImpl.deleteContactById(id);
	}
	
	//search functionality
	@GetMapping("/search")
	public ResponseEntity<List<ContactEntity>> searchCOntact(@RequestParam("query")String query) {
		return ResponseEntity.ok(mycontactServiceImpl.searchContacts(query));
		
	}
	//search using native query
	@GetMapping("/searchnative")
	public ResponseEntity<List<ContactEntity>> searchCOntactNative(@RequestParam("query") String query) {
		return ResponseEntity.ok(mycontactServiceImpl.searchContactsnative(query));
		
	}

}
