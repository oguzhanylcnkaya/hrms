package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(int jobSeekerId);
	
	DataResult<Resume> getById(int id);
	
	DataResult<List<Resume>> getByJobSeekerId(int jobSeekerId);
}
