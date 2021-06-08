package oguzhan.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.School;

public interface SchoolService {
	Result add(int resumeId, String schoolName, String department, LocalDate startDate, LocalDate endDate, boolean isGraduated);
	
	DataResult<List<School>> getByEndDate(int resumeId);
}
