package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers_activation_by_employees")
public class EmployersActivationByEmployees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="employers_id")
	private int employerId;
	
	@Column(name="employees_id")
	private int employeeId;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmed_date",
			columnDefinition = "Date default CURRENT_DATE")
	private Date confirmedDate;

}