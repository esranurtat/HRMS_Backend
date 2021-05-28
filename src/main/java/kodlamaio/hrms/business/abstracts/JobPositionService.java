package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import kodlamaio.hrms.entities.concretes.Users;

public interface JobPositionService {
	
	List<JobPosition> getAll();
	Result addJobPosition(JobPosition jobPosition);
	
}