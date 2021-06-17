package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateExperiencesService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateLinksService;
import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.business.abstracts.CandidateSkillsService;
import kodlamaio.hrms.business.abstracts.CvDtoService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperiencesDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLinksDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSchoolDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillsDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidatesDao;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvDtoManager implements CvDtoService {

	private CandidatesDao candidateDao;
	private CandidateSchoolDao  candidateSchoolDao;
	private CandidateSchoolService candidateSchoolService;
	private CandidateLanguageDao candidateLanguageDao;
	private CandidateLanguageService candidateLanguageService;
	private CandidateSkillsDao candidateSkillsDao;
	private CandidateSkillsService candidateSkillsService;
	private CandidateLinksDao candidateLinksDao;
	private CandidateLinksService candidateLinksService;
	private CandidateExperiencesDao candidateExperiencesDao;
	private CandidateExperiencesService candidateExperiencesService;
	
	
	@Autowired
	public CvDtoManager(CandidatesDao candidateDao, CandidateSchoolDao candidateSchoolDao, 
			CandidateSchoolService candidateSchoolService, CandidateLanguageService candidateLanguageService,
			CandidateLanguageDao candidateLanguageDao, CandidateSkillsDao candidateSkillsDao,
			CandidateSkillsService candidateSkillsService,CandidateLinksDao candidateLinksDao,
			CandidateLinksService candidateLinksService,CandidateExperiencesDao candidateExperiencesDao,
			CandidateExperiencesService candidateExperiencesService) {
		super();
		this.candidateDao = candidateDao;
		this.candidateSchoolDao = candidateSchoolDao;
		this.candidateSchoolService = candidateSchoolService;
		this.candidateLanguageService = candidateLanguageService;
		this.candidateLanguageDao = candidateLanguageDao;
		this.candidateSkillsDao = candidateSkillsDao;
		this.candidateSkillsService = candidateSkillsService;
		this.candidateLinksDao = candidateLinksDao;
		this.candidateLinksService = candidateLinksService;
		this.candidateExperiencesDao = candidateExperiencesDao;
		this.candidateExperiencesService = candidateExperiencesService;
	}

	@Override
	public Result add(CvDto cvDto, int candidateId) {
		Candidates candidate = this.candidateDao.findById(candidateId).get();
        cvDto.setCandidate(candidate);

        cvDto.getCandidateSchools().forEach(candidateSchool -> candidateSchool.setCandidate(candidate));
        candidateSchoolService.addAll(cvDto.getCandidateSchools());
        
        cvDto.getCandidateLanguages().forEach(candidateLanguage -> candidateLanguage.setCandidate(candidate));
        candidateLanguageService.addAll(cvDto.getCandidateLanguages());
        
        cvDto.getCandidateSkills().forEach(candidateSkills -> candidateSkills.setCandidate(candidate));
        candidateSkillsService.addAll(cvDto.getCandidateSkills());
        
        cvDto.getCandidateLinks().forEach(candidateLinks -> candidateLinks.setCandidate(candidate));
        candidateLinksService.addAll(cvDto.getCandidateLinks());
      
        cvDto.getCandidateExperiences().forEach(candidateExperiences -> candidateExperiences.setCandidate(candidate));
        candidateExperiencesService.addAll(cvDto.getCandidateExperiences());
        
        return new SuccessResult("Okullar ve Diller Cv'ye eklendi.");
	}

	@Override
	public DataResult<CvDto> getCVByCandidate(int candidateId) {
		CvDto cvDto = new CvDto();
		cvDto.setCandidate(this.candidateDao.getById(candidateId));
		cvDto.setCandidateSchools(this.candidateSchoolDao.getAllByCandidateIdOrderByEndedDate(candidateId));
		cvDto.setCandidateLanguages(this.candidateLanguageDao.getByCandidateId(candidateId));
		cvDto.setCandidateSkills(this.candidateSkillsDao.getByCandidateId(candidateId));
		cvDto.setCandidateLinks(this.candidateLinksDao.getByCandidateId(candidateId));
		cvDto.setCandidateExperiences(this.candidateExperiencesDao.getAllByCandidateIdOrderByLeaveDateDesc(candidateId));
		
	

		return new SuccessDataResult<CvDto>(cvDto);
	}

}