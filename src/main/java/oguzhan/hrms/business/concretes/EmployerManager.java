package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.EmployerService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.business.BusinessRules;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.EmployerDao;
import oguzhan.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.EmployerGetAll);
	}

	@Override
	public Result add(Employer employer) {
		
		var result = BusinessRules.run(isAllFieldNull(employer));
		
		if(result != null) {
			return result;
		}
		
		this.employerDao.save(employer);
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

}
