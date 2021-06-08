package oguzhan.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oguzhan.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	
	@Query("From Experience where resume.id = :resumeId Order By endDate")
	List<Experience> getByEndDate(int resumeId);
}
