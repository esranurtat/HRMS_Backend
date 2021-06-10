package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmailService {

	Result sendActivationCodeCandidates(Candidates candidate, String activationCode);
	Result sendActivationCodeEmployers(Employers employer, String activationCode);
}
