package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvDtoService {

	  Result add(CvDto cvDto,int candidateId);
	  DataResult<CvDto> getCVByCandidate(int candidateId);
}