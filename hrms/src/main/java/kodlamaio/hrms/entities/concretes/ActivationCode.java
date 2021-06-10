package kodlamaio.hrms.entities.concretes;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="activation_codes")
public class ActivationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "confirm_date", columnDefinition = "Date Default CURRENT_DATE")
	private LocalDate confirmDate;

}
