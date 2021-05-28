package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Users;

public interface ActivationCodeService {

	ActivationCode getByCode(String code);
	String createActivationCode(Users user);
	Result activateUser(String code);

}
