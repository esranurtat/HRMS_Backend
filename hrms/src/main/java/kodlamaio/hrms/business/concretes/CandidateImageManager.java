package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.core.utilities.imageService.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageDao;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@Service
public class CandidateImageManager implements CandidateImageService{

	private CandidateImageDao candidateImageDao;
	private ImageService imageService;
	
	@Autowired
	public CandidateImageManager(CandidateImageDao candidateImageDao,ImageService imageService) {
		super();
		this.candidateImageDao = candidateImageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(CandidateImage candidateImage) {
		this.candidateImageDao.save(candidateImage);
	      return new SuccessResult("Data eklendi.");
	}

	@Override
	public Result addAll(List<CandidateImage> candidateImages) {
		candidateImageDao.saveAll(candidateImages);
	      return new SuccessResult("Datalar eklendi.");
	}

	@Override
	public Result add(CandidateImage candidateImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        candidateImage.setUrl(url);
        candidateImage.setUploadedDate(LocalDateTime.now());
        return add(candidateImage);
	}

	@Override
	public DataResult<List<CandidateImage>> getAll() {
		return new SuccessDataResult<>(this.candidateImageDao.findAll());
	}

	@Override
	public DataResult<List<CandidateImage>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<>(this.candidateImageDao.getAllByCandidateId(candidateId));
	}

}