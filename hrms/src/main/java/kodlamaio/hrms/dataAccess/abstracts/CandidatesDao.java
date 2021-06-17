package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidates;

public interface CandidatesDao extends JpaRepository<Candidates, Integer> {

	Candidates getByEmail(String email);
	Candidates getById(int id);
	List<Candidates> findByNationalIdentity(String nationalityId);
	List<Candidates> findByEmail(String mail);
	Candidates findCandidatesByNationalIdentity(String nationalId);

}
