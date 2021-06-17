package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.LinkTypes;

public interface LinkTypeDao extends JpaRepository<LinkTypes, Integer> {

}