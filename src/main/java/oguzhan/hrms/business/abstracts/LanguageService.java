package oguzhan.hrms.business.abstracts;

import oguzhan.hrms.core.utilities.results.Result;

public interface LanguageService {
	Result add(int resumeId, String languageName, Short level);
}
