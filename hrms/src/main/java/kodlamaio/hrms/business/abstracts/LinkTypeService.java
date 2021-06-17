package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkTypes;

public interface LinkTypeService {

	  Result add(LinkTypes linkTypes);
	  DataResult<List<LinkTypes>> getAll();
}