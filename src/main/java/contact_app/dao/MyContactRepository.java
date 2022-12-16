package contact_app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import contact_app.entity.ContactEntity;

public interface MyContactRepository extends JpaRepository<ContactEntity,Long>{
	
	//search method() by using JPQL query 
	@Query("SELECT c FROM ContactEntity c WHERE " +
	"c.name LIKE CONCAT('%',:query, '%')" +
	"Or c.id LIKE CONCAT('%',:query, '%')" +
	"Or c.email LIKE CONCAT('%',:query, '%')")
	List<ContactEntity> searchContact(String query);
	
	//search method() by SQLNative query  here instead of class name we have to use table name okay 
	@Query(value = "SELECT * FROM contact_table c WHERE " +
	"c.name LIKE CONCAT('%',:query, '%')" +
	"Or c.id LIKE CONCAT('%',:query, '%')" +
	"Or c.email LIKE CONCAT('%',:query, '%')", nativeQuery = true)
	List<ContactEntity> searchContactNativeSQL(String query);
}
