package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguagesService;
import kodlamaio.hrms.entities.concretes.Languages;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguagesService languagesService;

	@Autowired
	public LanguagesController(LanguagesService languagesService) {
		super();
		this.languagesService = languagesService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Languages languages){
	        return ResponseEntity.ok(this.languagesService.add(languages));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
	    return ResponseEntity.ok(this.languagesService.getAll());
	}
	
	
}