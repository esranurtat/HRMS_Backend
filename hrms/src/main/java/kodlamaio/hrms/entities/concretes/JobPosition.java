package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table(name="job_positions")
@NoArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_adversitements"})
public class JobPosition {
	
	@Id //PrimaryKey
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AutoIncrement 
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvertisements> jobAdvertisements;

	public JobPosition( String title, List<JobAdvertisements> jobAdvertisements) {
		super();
		this.title = title;
		this.jobAdvertisements = jobAdvertisements;
	}
	
	
	
}