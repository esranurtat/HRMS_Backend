package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisements;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements, Integer> {

	@Query("From JobAdvertisements where isActive = true")
	List<JobAdvertisements> findByIsActiveTrue();
	
	@Query("From JobAdvertisements where isActive = true Order By applicationDeadline Desc")
	List<JobAdvertisements> findByIsActiveTrueOrderByApplicationDeadlineDesc();
	
	@Query("From JobAdvertisements where isActive = true and employer_id =:id")
	List<JobAdvertisements> findByIsActiveTrueAndEmployerId(int id);
}