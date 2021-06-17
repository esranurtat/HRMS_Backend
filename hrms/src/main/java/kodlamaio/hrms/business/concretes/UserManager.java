package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public DataResult<List<Users>> getAll() {		
		return new SuccessDataResult<List<Users>>(this.userDao.findAll());
	}

	@Override
	public Result addUsers(Users users) {
		this.userDao.save(users);
		return new SuccessResult("Kişi eklendi");
	}

	@Override
	public DataResult<Users> getUsersByEmail(String email) {
		return new SuccessDataResult<Users>(this.userDao.findUsersByEmail(email));
		
	}
	
	@Override
	public DataResult<Users> getById(int id) {
		return new SuccessDataResult<Users>(this.userDao.getOne(id));
	}
	
	
	
	

}