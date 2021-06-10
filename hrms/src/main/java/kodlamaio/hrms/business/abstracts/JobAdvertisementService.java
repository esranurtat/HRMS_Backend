package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.dataAccess.abtracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

public interface JobAdvertisementService {

	Result add(JobAdvertisements jobAdvertisements);

	Result update(JobAdvertisements jobAdvertisements);

	Result delete(int id);

	Result changeToActive(int id);

	DataResult<JobAdvertisements> getById(int id);

	DataResult<List<JobAdvertisements>> getAll();

	DataResult<List<JobAdvertisements>> getByIsActive();

	DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByApplicationDeadlineDesc();

	DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployerId(int id);

}