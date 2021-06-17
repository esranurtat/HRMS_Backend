package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

	@Query("From Department where id=:departmentId and university.id=:universityId and faculty.id=:facultyId")
	Department getByDepartmentId(int departmentId, int universityId, int facultyId);

}