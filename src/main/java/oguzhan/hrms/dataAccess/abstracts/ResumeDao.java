package oguzhan.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import oguzhan.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	Resume getById(int id);
	
	List<Resume> getByJobSeekerId(int jobSeekerId);
	
}
