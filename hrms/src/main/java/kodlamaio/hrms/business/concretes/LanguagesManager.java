package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguagesDao;
import kodlamaio.hrms.entities.concretes.Languages;

@Service
public class LanguagesManager implements LanguagesService {

	private final LanguagesDao languagesDao;

    @Autowired
    public LanguagesManager(LanguagesDao languagesDao) {
        this.languagesDao = languagesDao;
    }
    
	@Override
	public Result add(Languages language) {
		  this.languagesDao.save(language);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public DataResult<List<Languages>> getAll() {
		return new SuccessDataResult<List<Languages>>(this.languagesDao.findAll());
	}

}