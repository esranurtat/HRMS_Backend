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
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.Users;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private UserService userService;

	@Autowired
	public EmployersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/getall")
	public DataResult<List<Users>> getAll() {
		return this.userService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employers employer) {
		return this.userService.addUsers(employer);
	}

}
