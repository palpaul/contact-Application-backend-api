package contact_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contact_app.entity.Contact;

public interface ContactDao extends JpaRepository<Contact, Long>{

//	Contact findbyName(String contactName);

}
