package oguzhan.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oguzhan.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
	
	@Query("From School Where resume.id = :resumeId Order By endDate desc")
	List<School> getByEndDate(int resumeId);
}
