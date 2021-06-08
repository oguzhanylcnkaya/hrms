package oguzhan.hrms.business.abstracts;

import oguzhan.hrms.core.utilities.results.Result;

public interface SocialMediaAccountService {
	
	Result add(int resumeId, String githubUrl, String linkedinUrl);
}
