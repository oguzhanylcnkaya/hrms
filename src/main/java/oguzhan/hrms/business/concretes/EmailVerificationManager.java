package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.EmailVerificationService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.EmailVerificationDao;
import oguzhan.hrms.entities.concretes.EmailVerification;

@Service
public class EmailVerificationManager implements EmailVerificationService {

	private EmailVerificationDao emailVerificationDao;
	
	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		super();
		this.emailVerificationDao = emailVerificationDao;
	}

	@Override
	public Result add(EmailVerification emailVerification) {
		this.emailVerificationDao.save(emailVerification);
		return new SuccessResult(Messages.EmailVerified);
	}

	@Override
	public DataResult<EmailVerification> getByUserId(int userId) {
		
		return new SuccessDataResult<EmailVerification>(this.emailVerificationDao.getByUserId(userId));
	}

}
