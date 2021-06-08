package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.TechnologyService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.dataAccess.abstracts.TechnologyDao;
import oguzhan.hrms.entities.concretes.Resume;
import oguzhan.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao, ResumeDao resumeDao) {
		super();
		this.technologyDao = technologyDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String name) {
		
		Resume resume = this.resumeDao.getById(resumeId);
		
		Technology technology = new Technology(resume, name);
		this.technologyDao.save(technology);
		return new SuccessResult(Messages.TechnologyAdded);
		
	}

	

}
