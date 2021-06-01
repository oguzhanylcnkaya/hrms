package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.JobAdvertisement;
import oguzhan.hrms.entities.dtos.JobAdvertisementForDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	
	Result update(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<List<JobAdvertisementForDto>> getAllJobAdvertisementForDto();
	
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisement();
	
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDate();
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDateDesc();
	
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadline();
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadlineDesc();
	
	DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCompanyName(String companyName);
	
	Result doPassiveTheAdvertisement(int id);
	
	DataResult<JobAdvertisement> getById(int id);
}
