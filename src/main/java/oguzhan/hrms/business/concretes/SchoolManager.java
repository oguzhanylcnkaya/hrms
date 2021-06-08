package oguzhan.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.SchoolService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.dataAccess.abstracts.SchoolDao;
import oguzhan.hrms.entities.concretes.Resume;
import oguzhan.hrms.entities.concretes.School;


@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao, ResumeDao resumeDao) {
		super();
		this.schoolDao = schoolDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String schoolName, String department, LocalDate startDate, LocalDate endDate,
			boolean isGraduated) {
		
		Resume resume = this.resumeDao.getById(resumeId);
		School school;
		
		if(isGraduated) {
			
			school = new School(resume, schoolName, department, startDate, endDate, isGraduated);
			this.schoolDao.save(school);
			
		}
		else {
			school = new School(resume, schoolName, department, startDate, isGraduated);
			this.schoolDao.save(school);
		}
		
		return new SuccessResult(Messages.SchoolAdded);
	}

	
	
	@Override
	public DataResult<List<School>> getByEndDate(int resumeId) {
		return new SuccessDataResult<List<School>>(this.schoolDao.getByEndDate(resumeId));
	}

	

}
