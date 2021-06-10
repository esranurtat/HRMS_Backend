package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmailManager implements EmailService{

	@Autowired
	public EmailManager() {
		
	}

	@Override
	public Result sendActivationCodeCandidates(Candidates candidate, String activationCode) {
		String message = "Sayın " + candidate.getFirstName() + " "+ candidate.getLastName() + ", "+  candidate.getEmail() + " mail adresinize gönderilen aktivasyon kodunuz: "+ activationCode;
		return new SuccessResult(message);
	}

	@Override
	public Result sendActivationCodeEmployers(Employers employer, String activationCode) {
		String message = "Değerli " + employer.getCompanyName() + " şirketi, "+ employer.getEmail() + " mail adresinize gönderilen aktivasyon kodunuz: "+ activationCode;
		return new SuccessResult(message);
	}
}
