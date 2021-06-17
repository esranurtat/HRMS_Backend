package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLinksService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLinksDao;
import kodlamaio.hrms.entities.concretes.CandidateLinks;

@Service
public class CandidateLinkManager implements CandidateLinksService {

	private CandidateLinksDao candidateLinksDao;
	
	@Autowired
	public CandidateLinkManager(CandidateLinksDao candidateLinksDao) {
		super();
		this.candidateLinksDao = candidateLinksDao;
	}

	@Override
	public Result add(CandidateLinks candidateLinks) {
		 this.candidateLinksDao.save(candidateLinks);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateLinks> candidateLinks) {
		candidateLinksDao.saveAll(candidateLinks);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public DataResult<List<CandidateLinks>> getAll() {
		return new SuccessDataResult<>(this.candidateLinksDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLinks>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateLinksDao.getAllByCandidateId(candidateId));
	}

}