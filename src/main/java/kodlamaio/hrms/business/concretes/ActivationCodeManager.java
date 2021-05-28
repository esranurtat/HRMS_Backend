package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class ActivationCodeManager implements ActivationCodeService{
	
	private UserDao userDao;
	private ActivationCodeDao activationCodeDao;
	
	@Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao,UserDao userDao) {
        this.activationCodeDao = activationCodeDao;
        this.userDao=userDao;
	}

	@Override
	public ActivationCode getByCode(String code) {
		return this.activationCodeDao.findByActivationCode(code);
	}
	
	String code = "";
	@Override
	public String createActivationCode(Users user) {
		int randomCode = (int) (Math.random()*9999);
		code = String.valueOf(randomCode);
		
		ActivationCode activationCode=new ActivationCode();
        activationCode.setUserId(user.getId());
        activationCode.setActivationCode(code);
        activationCodeDao.save(activationCode);

		return code;
	}
	
	

	@Override
	public Result activateUser(String code) {
		 Users users = userDao.getOne(activationCodeDao.findByActivationCode(code).getUserId());
	        userDao.save(users);
	        return new SuccessResult("Kullanıcı aktif edildi");
	}

}
