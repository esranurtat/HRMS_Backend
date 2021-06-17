package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SkillsDao;
import kodlamaio.hrms.entities.concretes.Skills;

@Service
public class SkillsManager implements SkillsService {

	private SkillsDao skillsDao;

	@Autowired
	public SkillsManager(SkillsDao skillsDao) {
		super();
		this.skillsDao = skillsDao;
	}

	@Override
	public Result add(Skills skills) {
		this.skillsDao.save(skills);
		return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<Skills>> getAll() {
		return new SuccessDataResult<List<Skills>>(this.skillsDao.findAll());
	}

}