package oguzhan.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Experience;


public interface ExperienceService {
	Result add(int resumeId, String companyName, String positionName, LocalDate startDate, LocalDate endDate, boolean isWorkingNow);
	
	DataResult<List<Experience>> getByEndDate(int resumeId);
}
