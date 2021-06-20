package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	Result add(String workHour);
	
	DataResult<List<WorkType>> getAll();
}
