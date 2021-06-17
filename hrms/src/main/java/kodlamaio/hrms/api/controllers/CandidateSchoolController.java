package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSchoolService;
import kodlamaio.hrms.entities.concretes.CandidateSchool;

@RestController
@RequestMapping("/api/candidateSchool")
public class CandidateSchoolController {

	private CandidateSchoolService candidateSchoolService;

	@Autowired
	public CandidateSchoolController(CandidateSchoolService candidateSchoolService) {
		super();
		this.candidateSchoolService = candidateSchoolService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.candidateSchoolService.getAll());
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CandidateSchool candidateSchool) {
    	return ResponseEntity.ok(this.candidateSchoolService.add(candidateSchool));
    }
	
	@GetMapping("/getOrderBy")
	public ResponseEntity<?> getAllByCandidatesIdOrderByEndedDate(@RequestParam int candidateId){
		return  ResponseEntity.ok(this.candidateSchoolService.getAllByCandidatesIdOrderByEndedDate(candidateId));
	}
	
  
	
}