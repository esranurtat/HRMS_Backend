package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateExperiencesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperiencesDao;
import kodlamaio.hrms.entities.concretes.CandidateExperiences;

@Service
public class CandidateExperienceManager implements CandidateExperiencesService {

	private CandidateExperiencesDao candidateExperiencesDao;
	
	@Autowired
	public CandidateExperienceManager(CandidateExperiencesDao candidateExperiencesDao) {
		super();
		this.candidateExperiencesDao = candidateExperiencesDao;
	}

	@Override
	public Result add(CandidateExperiences candidateExperience) {
		this.candidateExperiencesDao.save(candidateExperience);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateExperiences> candidateExperience) {
		candidateExperiencesDao.saveAll(candidateExperience);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public DataResult<List<CandidateExperiences>> getAll() {
		return new SuccessDataResult<>(this.candidateExperiencesDao.findAll());
	}

	@Override
	public DataResult<List<CandidateExperiences>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
		return new SuccessDataResult<>(this.candidateExperiencesDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
	}

}