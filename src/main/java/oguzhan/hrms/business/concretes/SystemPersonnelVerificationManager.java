package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.SystemPersonnelVerificationService;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.SystemPersonnelVerificationDao;
import oguzhan.hrms.entities.concretes.SystemPersonnelVerification;

@Service
public class SystemPersonnelVerificationManager implements SystemPersonnelVerificationService{

	private SystemPersonnelVerificationDao systemPersonnelVerificationDao;
	
	@Autowired
	public SystemPersonnelVerificationManager(SystemPersonnelVerificationDao systemPersonnelVerificationDao) {
		super();
		this.systemPersonnelVerificationDao = systemPersonnelVerificationDao;
	}

	@Override
	public Result add(SystemPersonnelVerification systemPersonnelVerification) {
		systemPersonnelVerificationDao.save(systemPersonnelVerification);
		return new SuccessResult();
		
	}

}
