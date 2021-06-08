package oguzhan.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oguzhan.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
	
	@Query("From Photo where jobSeeker.id = :jobSeekerId")
	List<Photo> getByJobSeekerId(int jobSeekerId);
}
