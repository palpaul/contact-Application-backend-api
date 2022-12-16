package contact_app.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import contact_app.dao.MyContactRepository;
import contact_app.entity.ContactEntity;
import contact_app.service.MyContactService;

@Service
public class MyContactServiceImpl implements MyContactService{
	@Autowired
	private MyContactRepository mycntRepo;
	
	
	
	@Override
	public String saveContact(ContactEntity ctn) {
		ctn= mycntRepo.save(ctn); //insertion
		if(ctn.getId() !=null) {
			return "contact Saved";
		}else {
		return "Contact failed to save";
		}
		
	}

	@Override
	public List<ContactEntity> getAllContacts() {
		return mycntRepo.findAll();
	}

	@Override
	public ContactEntity getContactById(long ctnid) {
		Optional<ContactEntity> findById = mycntRepo.findById(ctnid);
		if(findById.isPresent()) {
			return findById.get();
		}
		else
			{
			return null;
			}
	}

	@Override
	public String UpdateContact(ContactEntity ctn) {
		// updation
//		ContactEntity upt = mycntRepo.save(ctn);
//		if(ctn.getId()!=null) {
//			return "Contact Updated Successfuly";
//		}else {
//			return "Contact updattion failed";
//		}
		//above aproch also wrok for update 
		
		if(mycntRepo.existsById(ctn.getId())) {
			mycntRepo.save(ctn);
			return "Contact updated...";
		}else
		{
			return "No Contacts Found";
		}
	}

	@Override
	public String deleteContactById(long ctnid) {
//			mycntRepo.deleteById(ctnid);
//		return "Record deleted successfully";
		
		if(mycntRepo.existsById(ctnid)) {
			mycntRepo.deleteById(ctnid);
			return "Record deleted successfully";
		}else {
			
			return "Record not found";
		}
		
	}
	//search method
	@Override
	public List<ContactEntity> searchContacts(String query) {
		// TODO Auto-generated method stub
	 	 List<ContactEntity> searchcontcts =  mycntRepo.searchContact(query);
		return searchcontcts;
	 	  	
	}
	
	//this method using search nativeQuery functionality
	@Override
	public List<ContactEntity> searchContactsnative(String query) {
		// TODO Auto-generated method stub
		List<ContactEntity> searchContactENtity =  mycntRepo.searchContactNativeSQL(query);
		return searchContactENtity;
	}

	
	
}
