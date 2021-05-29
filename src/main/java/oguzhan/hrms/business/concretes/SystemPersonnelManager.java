package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.SystemPersonnelService;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.SystemPersonnelDao;
import oguzhan.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{

	private SystemPersonnelDao systemPersonnelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}


	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult();
	}

}
