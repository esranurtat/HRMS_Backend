package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateExperiences;

public interface CandidateExperiencesDao extends JpaRepository<CandidateExperiences, Integer> {

	List<CandidateExperiences> getByCandidateId(int candidateId);

	List<CandidateExperiences> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}