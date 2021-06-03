package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "candidatesid")
@EqualsAndHashCode(callSuper=true)

public class Candidates extends Users {
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "nationalidentity")
	private String nationalIdentity;
	
	@Column(name = "dateofbirth")
	private Date dateOfBirth;
	
}