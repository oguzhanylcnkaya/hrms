package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByEmail(String email);
}
