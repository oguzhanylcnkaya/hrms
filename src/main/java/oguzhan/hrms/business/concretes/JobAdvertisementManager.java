package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.JobAdvertisementService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobAdvertisementDao;
import oguzhan.hrms.entities.concretes.JobAdvertisement;
import oguzhan.hrms.entities.dtos.JobAdvertisementForDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.JobAdvertisementAdded);
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getAllJobAdvertisementForDto() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getAllJobAdvertisementForDto());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisement());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisementByCreateDate());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDateDesc() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisementByCreateDateDesc());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadline() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisementByApplicationDeadline());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadlineDesc() {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisementByApplicationDeadlineDesc());
	}

	@Override
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisementForDto>>(this.jobAdvertisementDao.getActiveJobAdvertisementByCompanyName(companyName));
	}

	@Override
	public Result doPassiveTheAdvertisement(int id) {
		var result = this.jobAdvertisementDao.getById(id);
		
		if(result == null) {
			return new ErrorResult(Messages.JobAdvertisementNotFound);
		}
		
		JobAdvertisement advertisement = getById(id).getData();
		advertisement.setActive(false);
		update(advertisement);
		return new SuccessResult(Messages.JobAdvertisementPassive);
		
	}

	@Override
	public DataResult<JobAdvertisement> getById(int id) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(id), Messages.JobAdvertisementGetById);
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult(Messages.JobAdvertisementUpdated);
	}

}
