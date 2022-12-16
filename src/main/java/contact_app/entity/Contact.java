package contact_app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "CONTACT")
public class Contact {
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@GeneratedValue
	@Column(name = "CONTACT_ID")
	Long contactId;
	
	@Column(name = "CONTACT_NAME")
	String contactName;
	
	@Column(name = "CONTACT_EMAIL")
	String contactEmail;
	
	@Column(name = "CONTACT_NUM")
	long contactNum;
	
	//data annotation used so no need to write explicitly getter and setter

}
