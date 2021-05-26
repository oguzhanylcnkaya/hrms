package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.JobSeekerService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.adapter.abstracts.MernisCheckService;
import oguzhan.hrms.core.utilities.business.BusinessRules;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobSeekerDao;
import oguzhan.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	@Autowired
	private MernisCheckService mernisCheckService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisCheckService mernisCheckService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.JobSeekerGetAll);
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		var result = BusinessRules.run(isAllFieldNull(jobSeeker), checkUserMernisSuccess(jobSeeker));
		
		if(result != null) {
			return result;
		}
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JobSeekerAdd);
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

}
