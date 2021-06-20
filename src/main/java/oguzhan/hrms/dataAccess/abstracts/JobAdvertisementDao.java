package oguzhan.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import oguzhan.hrms.entities.concretes.JobAdvertisement;
import oguzhan.hrms.entities.dtos.JobAdvertisementForDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e")
	List<JobAdvertisementForDto> getAllJobAdvertisementForDto();
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and ja.didHrmsPersonnelAproved = true")
	List<JobAdvertisementForDto> getActiveJobAdvertisement();
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and ja.didHrmsPersonnelAproved = true Order By ja.createDate")
	List<JobAdvertisementForDto> getActiveJobAdvertisementByCreateDate();
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and ja.didHrmsPersonnelAproved = true Order By ja.createDate Desc")
	List<JobAdvertisementForDto> getActiveJobAdvertisementByCreateDateDesc();
	
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and ja.didHrmsPersonnelAproved = true Order By ja.applicationDeadline")
	List<JobAdvertisementForDto> getActiveJobAdvertisementByApplicationDeadline();
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and ja.didHrmsPersonnelAproved = true Order By ja.applicationDeadline Desc")
	List<JobAdvertisementForDto> getActiveJobAdvertisementByApplicationDeadlineDesc();
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.isActive = true and e.companyName = :companyName and ja.didHrmsPersonnelAproved = true")
	List<JobAdvertisementForDto> getActiveJobAdvertisementByCompanyName(String companyName);
	
	@Query("Select new oguzhan.hrms.entities.dtos.JobAdvertisementForDto(ja.id, e.companyName, jp.jobName, ja.openPositionQuantity, ja.createDate, ja.applicationDeadline) From JobAdvertisement ja Join ja.jobPosition jp Join ja.employer e Where ja.didHrmsPersonnelAproved = false")
	List<JobAdvertisementForDto> getNotApproveByHrmsPersonnel();
	
	JobAdvertisement getById(int id);
}
