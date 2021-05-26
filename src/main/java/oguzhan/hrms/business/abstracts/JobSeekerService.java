package oguzhan.hrms.business.abstracts;


import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.JobSeeker;
import java.util.List;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	
	Result add(JobSeeker jobSeeker);
}
