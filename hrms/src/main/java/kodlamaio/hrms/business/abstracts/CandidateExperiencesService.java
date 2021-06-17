package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperiences;

public interface CandidateExperiencesService {

	Result add(CandidateExperiences candidateExperience);

	Result addAll(List<CandidateExperiences> candidateExperience);

	DataResult<List<CandidateExperiences>> getAll();

	DataResult<List<CandidateExperiences>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}