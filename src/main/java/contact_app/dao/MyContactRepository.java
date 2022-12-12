package contact_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import contact_app.entity.ContactEntity;

public interface MyContactRepository extends JpaRepository<ContactEntity,Long>{

}
