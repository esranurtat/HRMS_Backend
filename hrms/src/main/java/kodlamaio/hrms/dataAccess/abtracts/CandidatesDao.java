package kodlamaio.hrms.dataAccess.abtracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer>{

	Candidates getByEmail(String email);
	List<Candidates> findByNationalIdentity(String nationalityId);
	List<Candidates> findByEmail(String mail);
	Candidates findCandidatesByNationalIdentity(String nationalId);
}
