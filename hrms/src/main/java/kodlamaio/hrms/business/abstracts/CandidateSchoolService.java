package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

public interface CandidateSchoolService {

	 Result add(CandidateSchool candidateSchool);
	 DataResult<List<CandidateSchool>> getAll();
	 Result addAll(List<CandidateSchool> candidateSchools);
	 DataResult<List<CandidateSchool>> getAllByCandidatesIdOrderByEndedDate(int candidateId);
	 
}