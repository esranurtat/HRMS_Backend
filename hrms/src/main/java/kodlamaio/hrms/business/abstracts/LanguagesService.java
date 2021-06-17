package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Languages;

public interface LanguagesService {

	  Result add(Languages language);
	  DataResult<List<Languages>> getAll();
}