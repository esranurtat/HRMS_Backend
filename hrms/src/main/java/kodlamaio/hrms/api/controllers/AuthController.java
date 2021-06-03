package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Employers;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	
	@PostMapping("/registerEmployer")
	public Result registerEmployer(@RequestBody Employers employer,String confirmPassword) {
		return this.authService.registerEmployer(employer, confirmPassword);
	}
	

	@PostMapping("/registerCandidate")
	public Result registerCandidate(@RequestBody Candidates candidate ,String confirmPassword) {
		return this.authService.registerCandidate (candidate, confirmPassword);
	}
}
