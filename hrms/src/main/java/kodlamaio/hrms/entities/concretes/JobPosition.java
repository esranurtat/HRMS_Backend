package kodlamaio.hrms.entities.concretes;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Table(name="job_positions")
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
	
	@Id //PrimaryKey
	@GeneratedValue(strategy=GenerationType.IDENTITY) //AutoIncrement 
	
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	
	
}