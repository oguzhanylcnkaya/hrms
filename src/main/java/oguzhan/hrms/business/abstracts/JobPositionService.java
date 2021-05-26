package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
	
	Result isJobPositionExist(String jobPosition);
	
	DataResult<JobPosition> getByJobName(String jobName);
}
