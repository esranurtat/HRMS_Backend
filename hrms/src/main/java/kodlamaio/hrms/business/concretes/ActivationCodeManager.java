package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abtracts.ActivationCodeDao;
import kodlamaio.hrms.dataAccess.abtracts.UserDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Users;


@Service
public class ActivationCodeManager implements ActivationCodeService{
	
	private ActivationCodeDao activationCodeDao;
	
	@Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
        this.activationCodeDao = activationCodeDao;
	}
	

	@Override
	public Result add(ActivationCode code) {
		this.activationCodeDao.save(code);
		return new SuccessResult("Kod kayıt edildi!");
	}


	@Override
	public boolean sendActivationCode(String emailAddress) {
	
		    String code= createActivationCode();
			System.out.println(emailAddress +"Verification code sent to address . Verification code:" + code );
			return true;
	}
	
	String code = "";
	public String createActivationCode() {
		int randomCode = (int) (Math.random()*9999);
		code = String.valueOf(randomCode);
		return code;
	}

	
	
	
	
}