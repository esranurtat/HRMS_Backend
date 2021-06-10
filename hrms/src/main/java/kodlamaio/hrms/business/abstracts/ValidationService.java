package kodlamaio.hrms.business.abstracts;

import java.util.Date;

import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

public interface ValidationService {
	
	boolean CheckIfMernisPerson(String nationalityId,String firstName,String lastName,Date birthday);;
	boolean checkIfExistNationalId(String nationalId);
	boolean checkIfNullinfoForCandidates(Candidates candidate);
	boolean checkIfNullinfoForEmployers(Employers employer);
//	boolean checkEmailAndDomain(String email, String website);
	boolean checkIfEmailExists(String email);
	boolean checkIfConfirmPassword(String password, String confirmPassword);
	boolean isValidEmail(String email);

}
