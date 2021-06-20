package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.WorkHour;

public interface WorkHourService {
	Result add(String workHourType);
	
	DataResult<List<WorkHour>> getAll();
}
