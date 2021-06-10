package kodlamaio.hrms.dataAccess.abtracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employees;

public interface EmployeesDao extends JpaRepository<Employees, Integer> {

}