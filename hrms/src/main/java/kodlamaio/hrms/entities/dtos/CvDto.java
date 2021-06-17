package kodlamaio.hrms.entities.dtos;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.Dto;
import kodlamaio.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvDto implements Dto {

	@JsonIgnore
	private Candidates candidate;
	private List<@Valid CandidateSchool> candidateSchools;
	private List<@Valid CandidateLanguage> candidateLanguages;
	private List<@Valid CandidateSkills> candidateSkills;
	private List<@Valid CandidateLinks> candidateLinks;
	private List<@Valid CandidateExperiences> candidateExperiences;
}