package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class CandidatesManager implements CandidatesService {

	private CandidatesDao candidatesDao;

	@Autowired
	public CandidatesManager(CandidatesDao candidatesDao) {
		this.candidatesDao = candidatesDao;
	}

	
	
	@Override
	public DataResult<List<Candidates>> getAll() {
		return new SuccessDataResult<List<Candidates>>(this.candidatesDao.findAll(), "Data Listelendi");
	}

	
	@Override
	public Result add(Candidates candidates) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.save(candidates), "Data eklendi");
	}
	

	@Override
	public Result isNationalityIdExist(String nationalityId) {

		if (candidatesDao.findByNationalIdentity(nationalityId).isEmpty()) {
			return new SuccessResult();

		} else {
			return new ErrorResult("Bu Tc kimlik no ile kayıtlı kullanıcı var.");
		}
	}

	
	@Override
	public Result isCandidatesEmailExist(String mail) {
		if (candidatesDao.findByEmail(mail).isEmpty()) {
			return new SuccessResult();

		} else {
			return new ErrorResult("Bu mail ile kayıtlı kullanıcı var.");
		}
	}

	
	@Override
	public Result addCandidate(Candidates candidates) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.save(candidates), "Data Eklendi");
	}

	
	@Override
	public DataResult<Candidates> getByNationalId(String nationalId) {
		return new SuccessDataResult<Candidates>(this.candidatesDao.findCandidatesByNationalIdentity(nationalId));
	}

}