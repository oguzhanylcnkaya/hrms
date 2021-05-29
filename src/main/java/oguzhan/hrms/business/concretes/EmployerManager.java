package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.EmailVerificationService;
import oguzhan.hrms.business.abstracts.EmployerService;
import oguzhan.hrms.business.abstracts.SystemPersonnelVerificationService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.business.BusinessRules;
import oguzhan.hrms.core.utilities.helpers.MailVerificationService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.EmployerDao;
import oguzhan.hrms.entities.concretes.EmailVerification;
import oguzhan.hrms.entities.concretes.Employer;
import oguzhan.hrms.entities.concretes.SystemPersonnelVerification;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private EmailVerificationService emailVerificationService;
	private MailVerificationService mailVerificationService;
	private SystemPersonnelVerificationService systemPersonnelVerificationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerificationService emailVerificationService,
			MailVerificationService mailVerificationService,
			SystemPersonnelVerificationService systemPersonnelVerificationService) {
		super();
		this.employerDao = employerDao;
		this.emailVerificationService = emailVerificationService;
		this.mailVerificationService = mailVerificationService;
		this.systemPersonnelVerificationService = systemPersonnelVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.EmployerGetAll);
	}

	@Override
	public Result add(Employer employer) {
		
		var result = BusinessRules.run(isAllFieldNull(employer), isEmailregistered(employer));
		
		if(result != null) {
			return result;
		}
		
		this.employerDao.save(employer);
		
		String code = mailVerificationService.sendCode();
		addVerificationCode(employer, code);
		addSystemPersonnelVerification(employer);
		
		return new SuccessResult(Messages.EmployerAdd);
	}
	
	private Result isAllFieldNull(Employer employer) {
		
		if(employer.getCompanyName() == null || employer.getCompanyName().equals("") || 
				employer.getEmail() == null || employer.getEmail().equals("") || 
				employer.getPassword() == null || employer.getPassword().equals("") || 
				employer.getPhoneNumber() == null || employer.getPhoneNumber().equals("") ||
				employer.getWebsite() == null || employer.getWebsite().equals("")) {
			return new ErrorResult(Messages.EmployerNullField);
		}
		
		return new SuccessResult();
	}
	
	private Result isEmailregistered(Employer employer) {
		
		var result = this.employerDao.getByEmail(employer.getEmail());
		
		if(result != null) {
			return new ErrorResult(Messages.EmailRegistered);
		}
		return new SuccessResult();
	}

	private Result addVerificationCode(Employer employer, String code) {
		
		EmailVerification emailVerification = new EmailVerification(employer.getId(), false, code);
		this.emailVerificationService.add(emailVerification);
		System.out.println("Doğrulama kodu gönderildi " + employer.getEmail());
		return new SuccessResult();
	}
	
	private Result addSystemPersonnelVerification(Employer employer) {
		SystemPersonnelVerification systemPersonnelVerification = new SystemPersonnelVerification(employer.getId(), false);
		
		this.systemPersonnelVerificationService.add(systemPersonnelVerification);
		return new SuccessResult();
		
	}
}
