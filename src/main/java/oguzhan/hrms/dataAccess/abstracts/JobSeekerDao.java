package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	JobSeeker getByEmailOrIdentityNumber(String email, String identityNumber);
	
	JobSeeker getById(int id);
}
