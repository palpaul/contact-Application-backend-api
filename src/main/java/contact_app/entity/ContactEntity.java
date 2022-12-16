package contact_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Entity
	@Table(name= "CONTACT_TABLE")
	public class ContactEntity {
		
		
		//@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Id
		@GeneratedValue
		@Column(name = "ID")
		Long id;
		
		@Column(name = "NAME")
		String name;
		
		@Column(name = "EMAIL")
		String email;
		
		@Column(name = "phno")
		long phno;
		
		//data annotation used so no need to write explicitly getter and setter

	}


