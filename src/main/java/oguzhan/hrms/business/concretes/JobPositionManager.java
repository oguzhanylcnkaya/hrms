package oguzhan.hrms.business.concretes;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.JobPositionService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.business.BusinessRules;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobPositionDao;
import oguzhan.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), Messages.jobPositionGetAll);
	}


	@Override
	public Result add(JobPosition jobPosition) {
		
		var result = BusinessRules.run(isJobPositionExist(jobPosition.getJobName()));
		
		if(result != null) {
			return result;
		}
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.jobPositionAdd);
		
	}


	@Override
	public Result isJobPositionExist(String jobPosition) {
		var result = getByJobName(jobPosition);
		
		if(result.getData() != null) {
			return new ErrorResult(Messages.JobPositionExist);
		}
		
		return new SuccessResult();
		
	}


	@Override
	public DataResult<JobPosition> getByJobName(String jobName) {
		return new SuccessDataResult<JobPosition>(this.jobPositionDao.findByJobName(jobName));
	}


	

}
