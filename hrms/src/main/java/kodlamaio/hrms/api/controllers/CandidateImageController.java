package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.Candidates;

@RestController
@RequestMapping("/api/candidateImages")
public class CandidateImageController {

	private CandidateImageService candidateImageService;

	@Autowired
	public CandidateImageController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file, @RequestParam int candidateId) {
		CandidateImage candidateImage = new CandidateImage();
		Candidates candidate = new Candidates();
		candidate.setId(candidateId);
		candidateImage.setCandidate(candidate);
		return ResponseEntity.ok(this.candidateImageService.add(candidateImage, file));
	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.candidateImageService.getAll());
	}
}