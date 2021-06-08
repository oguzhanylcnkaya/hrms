package oguzhan.hrms.business.abstracts;

import oguzhan.hrms.core.utilities.results.Result;

public interface CoverLetterService {
	
	Result add(int resumeId, String coverLetter);
	
}
