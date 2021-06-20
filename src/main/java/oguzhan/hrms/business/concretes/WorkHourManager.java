package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.WorkHourService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.WorkHourDao;
import oguzhan.hrms.entities.concretes.WorkHour;

@Service
public class WorkHourManager implements WorkHourService {

	private WorkHourDao workHourDao;
	
	@Autowired
	public WorkHourManager(WorkHourDao workHourDao) {
		super();
		this.workHourDao = workHourDao;
	}

	@Override
	public Result add(String workHourType) {
		WorkHour workHour = new WorkHour(workHourType);
		
		this.workHourDao.save(workHour);
		
		return new SuccessResult(Messages.WorkHourAdded);
	}

	@Override
	public DataResult<List<WorkHour>> getAll() {
		return new SuccessDataResult<List<WorkHour>>(this.workHourDao.findAll(), Messages.WorkHourGetAll);
	}

}
