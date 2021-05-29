package oguzhan.hrms.business.abstracts;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationService {
	Result add(EmailVerification emailVerification);
	DataResult<EmailVerification> getByUserId(int userId);
}
