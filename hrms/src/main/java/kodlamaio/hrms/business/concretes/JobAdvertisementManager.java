package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abtracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementsDao jobAdvertisementsDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementsDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public Result add(JobAdvertisements jobAdvertisements) {
		if (!CheckIfNullField(jobAdvertisements)) {
			return new ErrorResult("Lütfen boş alanları kontrol ediniz!");
		}
		this.jobAdvertisementsDao.save(jobAdvertisements);
		return new SuccessResult("İş ilanı eklendi.");
	}

	@Override
	public Result update(JobAdvertisements jobAdvertisements) {
		this.jobAdvertisementsDao.save(jobAdvertisements);
		return new SuccessResult("İş ilanı güncellendi.");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertisementsDao.deleteById(id);
		return new SuccessResult("İş ilanı kaldırıldı.");
	}

	@Override
	public Result changeToActive(int id) {
		if (getById(id) == null) {
			return new ErrorResult("Böyle bir iş ilanı yok!");
		}
		if (getById(id).getData().isActive() == false) {
			return new SuccessResult("İş ilani zaten kapalı!");

		}
		JobAdvertisements jobAdvertisements = getById(id).getData();
		jobAdvertisements.setActive(false);
		update(jobAdvertisements);
		return new SuccessResult("İş ilanı başarılı şekilde kapatıldı!");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActive() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisements>>(
				this.jobAdvertisementsDao.findByIsActiveTrueOrderByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployerId(int id) {
		return new SuccessDataResult<List<JobAdvertisements>>(
				this.jobAdvertisementsDao.findByIsActiveTrueAndEmployerId(id));
	}

	@Override
	public DataResult<List<JobAdvertisements>> getAll() {
		return new SuccessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.findAll());

	}

	@Override
	public DataResult<JobAdvertisements> getById(int id) {
		return new SuccessDataResult<JobAdvertisements>(this.jobAdvertisementsDao.getOne(id));
	}
	

	private boolean CheckIfNullField(JobAdvertisements jobAdvertisements) {
		if (jobAdvertisements.getJobPosition() != null && jobAdvertisements.getCity() != null && jobAdvertisements.getEmployer() != null && jobAdvertisements.getJobDetail() != null&& jobAdvertisements.getEmployer() != null && jobAdvertisements.getPositionQuota()!= 0) {
			return true;
		}
		return false;
	}


}