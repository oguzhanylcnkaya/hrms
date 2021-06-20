package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.WorkTypeService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.WorkTypeDao;
import oguzhan.hrms.entities.concretes.WorkType;

@Service
public class WorkTypeManager implements WorkTypeService{

	private WorkTypeDao workTypeDao;
	
	@Autowired
	public WorkTypeManager(WorkTypeDao workTypeDao) {
		super();
		this.workTypeDao = workTypeDao;
	}

	@Override
	public Result add(String workHour) {
		
		WorkType workType = new WorkType(workHour);
		
		this.workTypeDao.save(workType);
		return new SuccessResult(Messages.WorkTypeAdded);
		
	}

	@Override
	public DataResult<List<WorkType>> getAll() {
		return new SuccessDataResult<List<WorkType>>(this.workTypeDao.findAll());
	}

	

}
