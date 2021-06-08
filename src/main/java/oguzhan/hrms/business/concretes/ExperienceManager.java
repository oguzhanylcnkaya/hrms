package oguzhan.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.ExperienceService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.ExperienceDao;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.entities.concretes.Experience;
import oguzhan.hrms.entities.concretes.Resume;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public ExperienceManager(ExperienceDao experienceDao, ResumeDao resumeDao) {
		super();
		this.experienceDao = experienceDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String companyName, String positionName, LocalDate startDate, LocalDate endDate,
			boolean isWorkingNow) {
		
		Resume resume = this.resumeDao.getById(resumeId);
		Experience experience;
		
		if(isWorkingNow) {
			
			experience = new Experience(companyName, positionName, startDate, isWorkingNow, resume);
			this.experienceDao.save(experience);
			
		}
		else {
			experience = new Experience(companyName, positionName, startDate, endDate, isWorkingNow, resume);
			this.experienceDao.save(experience);
		}
		
		return new SuccessResult(Messages.ExperienceAdded);
	}

	@Override
	public DataResult<List<Experience>> getByEndDate(int resumeId) {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.getByEndDate(resumeId));
	}

	

}
