package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.EmailVerificationService;
import oguzhan.hrms.business.abstracts.JobSeekerService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.adapter.abstracts.MernisCheckService;
import oguzhan.hrms.core.utilities.business.BusinessRules;
import oguzhan.hrms.core.utilities.helpers.MailVerificationService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobSeekerDao;
import oguzhan.hrms.entities.concretes.EmailVerification;
import oguzhan.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;
	private MailVerificationService mailVerificationService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService, EmailVerificationService emailVerificationService,
			MailVerificationService mailVerificationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
		this.mailVerificationService = mailVerificationService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.JobSeekerGetAll);
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		var result = BusinessRules.run(isAllFieldNull(jobSeeker), 
				checkUserMernisSuccess(jobSeeker),
				isEmailOrIdentityNumberRegistered(jobSeeker));
		
		if(result != null) {
			return result;
		}
		
		this.jobSeekerDao.save(jobSeeker);
		
		String code = mailVerificationService.sendCode();
		addVerificationCode(jobSeeker, code);
		
		return new SuccessResult(Messages.JobSeekerAdd);
	}
	
	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

	private Result isAllFieldNull(JobSeeker jobSeeker) {
		
		if(jobSeeker.getBirthDate() == null || 
				jobSeeker.getEmail() == null || jobSeeker.getEmail().equals("") ||
				jobSeeker.getFirstName() == null || jobSeeker.getFirstName().equals("") ||
				jobSeeker.getIdentityNumber() == null || jobSeeker.getIdentityNumber().equals("") ||
				jobSeeker.getLastName() == null || jobSeeker.getLastName().equals("") ||
				jobSeeker.getPassword() == null || jobSeeker.getPassword().equals("")) {
			
			return new ErrorResult(Messages.JobSeekerNullField);
		}
		
		return new SuccessResult();
		
	}
	
	private Result checkUserMernisSuccess(JobSeeker jobSeeker) {
		
		if(mernisCheckService.validate(jobSeeker.getIdentityNumber(), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getBirthDate())) {
			return new SuccessResult(Messages.MernisSuccess);
		}
		
		return new ErrorResult(Messages.MernisError);
	}
	
	private Result isEmailOrIdentityNumberRegistered(JobSeeker jobSeeker) {
		
		var result = this.jobSeekerDao.getByEmailOrIdentityNumber(jobSeeker.getEmail(), jobSeeker.getIdentityNumber());
		
		if(result != null) {
			return new ErrorResult(Messages.EmailOrIdentityRegistered);
		}
		return new SuccessResult();
	}
	
	private Result addVerificationCode(JobSeeker jobSeeker, String code) {
		
		EmailVerification emailVerification = new EmailVerification(jobSeeker.getId(), false, code);
		this.emailVerificationService.add(emailVerification);
		System.out.println("Doğrulama kodu gönderildi " + jobSeeker.getEmail());
		return new SuccessResult();
	}

	

}
