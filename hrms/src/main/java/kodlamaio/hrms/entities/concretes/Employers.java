package kodlamaio.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employersid")
@EqualsAndHashCode(callSuper=true)

public class Employers extends Users {

	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "webaddress")
	private String webAddress;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
}