package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "employersid")
@EqualsAndHashCode(callSuper=true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_advertisements"})

public class Employers extends Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "employersid")
	private int id;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "webaddress")
	private String webAddress;
	
	@Column(name = "phonenumber")
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisements> jobAdversitements;
	
	
}