package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillsDao;
import kodlamaio.hrms.entities.concretes.CandidateSkills;

@Service
public class CandidateSkillsManager implements CandidateSkillsService {

	private CandidateSkillsDao candidateSkillsDao;

	@Autowired
	public CandidateSkillsManager(CandidateSkillsDao candidateSkillsDao) {
		super();
		this.candidateSkillsDao = candidateSkillsDao;
	}

	@Override
	public Result add(CandidateSkills candidateSkills) {
		this.candidateSkillsDao.save(candidateSkills);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateSkills> candidateSkill) {
		candidateSkillsDao.saveAll(candidateSkill);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public DataResult<List<CandidateSkills>> getAll() {
		 return new SuccessDataResult<>(this.candidateSkillsDao.findAll());
	}

	@Override
	public DataResult<List<CandidateSkills>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateSkillsDao.getAllByCandidateId(candidateId));
	}

}