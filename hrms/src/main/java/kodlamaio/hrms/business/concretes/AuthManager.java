package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.ValidationService;
import kodlamaio.hrms.core.utilities.adapter.MernisServiceAdapter;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.Users;

@Service
public class AuthManager implements AuthService {

	private EmployersService employerService;
	private UserService userService;
	private CandidatesService candidateService;
	private ActivationCodeService activationCodeService;
	private ValidationService validationService;
	private EmailService emailService;
	private ActivationCodeDao activationCodeDao;

	@Autowired
	public AuthManager(UserService userService, EmployersService employerService, CandidatesService candidateService,
			ActivationCodeService activationCodeService, ValidationService validationService, EmailService emailService,
			ActivationCodeDao activationCodeDao) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.activationCodeService = activationCodeService;
		this.validationService = validationService;
		this.emailService = emailService;
		this.activationCodeDao = activationCodeDao;

	}

	@Override
	public Result registerEmployer(Employers employer, String confirmPassword) {

		if (!validationService.isValidEmail(employer.getEmail())) {
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}

		if (!validationService.checkIfNullinfoForEmployers(employer)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

//		if (!validationService.checkEmailAndDomain(employer.getEmail(), employer.getWebAddress())) {
//			return new ErrorResult("Invalid email address or website adress.");
//		}
	//4112198*-/56
		
		
		if (!validationService.checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult(employer.getEmail() + " Invalid email address.");
		}

		if (!validationService.checkIfConfirmPassword(employer.getPassword(), confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}

		String activationCode = createActivationCode();
		this.employerService.addEmployer(employer);
		createActivationProcess(employer, activationCode);

		return emailService.sendActivationCodeEmployers(employer, activationCode);

	}
	
	

	@Override
	public Result registerCandidate(Candidates candidate, String confirmPassword) {

		if (!validationService.isValidEmail(candidate.getEmail())) {
			return new ErrorResult("Invalid email address. Please enter your email address correctly.");
		}

		if (!validationService.checkIfExistNationalId(candidate.getNationalIdentity())) {
			return new ErrorResult("This nationalId is already exist. Please enter a different email address.");
		}

		if (!validationService.checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult(candidate.getEmail() + " This email is already exist. Please enter a different email address.");
		}

		if (!validationService.checkIfNullinfoForCandidates(candidate)) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}

		if (!validationService.checkIfConfirmPassword(candidate.getPassword(), confirmPassword)) {
			return new ErrorResult("Password does not match. Please re-enter your password.");
		}

		if (!validationService.CheckIfMernisPerson(candidate.getNationalIdentity(), candidate.getFirstName(),
				candidate.getLastName(), candidate.getDateOfBirth())) {

			return new ErrorResult("Candidate is not registered in the mernis system.");
		}

		String activationCode = createActivationCode();
		this.candidateService.addCandidate(candidate);
		createActivationProcess(candidate, activationCode);

		return emailService.sendActivationCodeCandidates(candidate, activationCode);

	}

	
	@Override
	public Result confirmEmail(int id, String confirmActivationCode) {

		ActivationCode activationCodeTable = activationCodeDao.getOne(id);

		if (activationCodeTable.getId() != id) {
			return new ErrorResult("Id uyuşmazlık sorunu!!");
		} else if (!activationCodeDao.findById(activationCodeTable.getId()).isPresent()) {
			return new ErrorResult("Activation Code Tablosunda " + id + " id numarasına sahip kişi bulunumadı!!");
		} else if (!confirmActivationCode.equals(activationCodeTable.getActivationCode())) {
			return new ErrorResult("Email Doğrulama kodunuz hatalı!");
		} else if (activationCodeTable.isConfirmed() == false) {
			activationCodeTable.setConfirmed(true);
			activationCodeDao.save(activationCodeTable);
			return new SuccessResult("E-mail Doğrulama Başarılı!");
		} else {
			return new ErrorResult("E-mail zaten doğrulanmış");
		}

	}

	private String createActivationCode() {
//		int upperBound = 9999, lowerBound = 1000;
//		int randomCode = lowerBound + (int) (Math.random() * (upperBound - lowerBound) + 1);
//		String code = String.valueOf(randomCode);
//		return code;
		UUID uuid = UUID.randomUUID();
		String code = String.valueOf(uuid);
		return code;

	}

	public void createActivationProcess(Users user, String activationCode) {
		ActivationCode activationObject = new ActivationCode();
		activationObject.setUserId(user.getId());
		activationObject.setConfirmed(false);
		activationObject.setConfirmDate(LocalDate.now());
		activationObject.setActivationCode(activationCode);
		this.activationCodeService.add(activationObject);
	}

}
