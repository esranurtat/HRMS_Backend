package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLinks;

public interface CandidateLinksService {

	Result add(CandidateLinks candidateLinks);

	Result addAll(List<CandidateLinks> candidateLinks);

	DataResult<List<CandidateLinks>> getAll();

	DataResult<List<CandidateLinks>> getAllByCandidateId(int candidateId);
}