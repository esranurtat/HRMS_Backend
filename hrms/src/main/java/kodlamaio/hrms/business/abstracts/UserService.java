package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Users;

public interface UserService {
	
	DataResult<Users> getUsersByEmail(String email);
	DataResult<List<Users>> getAll();
	Result addUsers(Users users);
	DataResult<Users> getById(int id);
}
