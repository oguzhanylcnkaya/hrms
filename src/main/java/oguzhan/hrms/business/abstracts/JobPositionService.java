package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
