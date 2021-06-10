package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.abstracts.MernisCheckService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.ValidationService;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class ValidationManager implements ValidationService {
	
	private UserService userService;
	private CandidatesService candidateService;	
	private MernisCheckService mernisCheckService;
	
	@Autowired
	public ValidationManager(CandidatesService candidateService, 
			   				 UserService userService, 
			   				MernisCheckService mernisCheckService) 
	{
		super();
		this.candidateService = candidateService;
		this.userService = userService;
		this.mernisCheckService = mernisCheckService;
	}
	
	
	@Override
	public boolean CheckIfMernisPerson(String nationalityId,String firstName,String lastName,Date birthday){		
		return mernisCheckService.checkVirtualPerson( nationalityId, firstName, lastName, birthday);
	}

	@Override
	public boolean checkIfExistNationalId(String nationalId) {		
		return candidateService.getByNationalId(nationalId).getData() == null;
	}

	@Override
	public boolean checkIfNullinfoForCandidates(Candidates candidate) 
	{
		if(candidate.getFirstName() != null && !candidate.getFirstName().isEmpty() &&
		   candidate.getEmail() != null && !candidate.getEmail().isEmpty() &&
		   candidate.getPassword() != null && !candidate.getPassword().isEmpty() &&
		   candidate.getLastName() != null && !candidate.getLastName().isEmpty() &&
		   candidate.getNationalIdentity() != null && !candidate.getNationalIdentity().isEmpty() &&
		   candidate.getDateOfBirth() != null
		   )
		{
			return true;
		}
				
		return false;
	}

	@Override
	public boolean checkIfNullinfoForEmployers(Employers employer) 
	{
		if(employer.getCompanyName() != null && !employer.getCompanyName().isEmpty() &&
		   employer.getEmail() != null && !employer.getEmail().isEmpty() &&
		   employer.getPassword() != null && !employer.getPassword().isEmpty() &&
		   employer.getPhoneNumber() != null && !employer.getPhoneNumber().isEmpty() &&
		   employer.getWebAddress() != null && !employer.getWebAddress().isEmpty() 
		  )
		{
			return true;
		}
				
		return false;
	}

//	@Override
//	public boolean checkEmailAndDomain(String email, String website) {
//		
//		String mailDomain = email.split("@")[1];
//		
//		return mailDomain.equals(website);
//	}

	@Override
	public boolean checkIfEmailExists(String email) {
		
		return this.userService.getUsersByEmail(email).getData()==null;
	
	}

	@Override
	public boolean checkIfConfirmPassword(String password, String confirmPassword) {
		
		return password.equals(confirmPassword);
	
	}


	@Override
	public boolean isValidEmail(String email) {
		String emailRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{3}\\b";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

}