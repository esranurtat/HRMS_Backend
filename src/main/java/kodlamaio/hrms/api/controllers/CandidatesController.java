package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidates;
import kodlamaio.hrms.entities.concretes.Users;
import kodlamaio.hrms.core.utilities.results.Result;


@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private UserService userService;
    
	@Autowired
	public CandidatesController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Users>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping("/add")
    public Result add(@RequestBody Candidates candidate) {
    	return this.userService.addUsers(candidate);
    }
	
	
	
}