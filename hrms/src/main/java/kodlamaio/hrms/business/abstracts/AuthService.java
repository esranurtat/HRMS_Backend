package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

public interface AuthService {

	Result registerEmployer(Employers employer,String confirmPassword);
	Result registerCandidate(Candidates candidate ,String confirmPassword);
}