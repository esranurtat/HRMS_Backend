package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSkills;

public interface CandidateSkillsService {

	Result add(CandidateSkills candidateSkills);

	Result addAll(List<CandidateSkills> candidateSkill);

	DataResult<List<CandidateSkills>> getAll();

	DataResult<List<CandidateSkills>> getAllByCandidateId(int candidateId);
}