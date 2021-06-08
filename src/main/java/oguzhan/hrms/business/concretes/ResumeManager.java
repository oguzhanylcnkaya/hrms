package oguzhan.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.ResumeService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobSeekerDao;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.entities.concretes.JobSeeker;
import oguzhan.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, JobSeekerDao jobSeekerDao) {
		super();
		this.resumeDao = resumeDao;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(int jobSeekerId) {

		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		Resume resume = new Resume(jobSeeker);
		
		this.resumeDao.save(resume);
		return new SuccessResult(Messages.ResumeAdded);
	}

	@Override
	public DataResult<Resume> getById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getById(id), Messages.ResumeGetById);
	}

	@Override
	public DataResult<List<Resume>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByJobSeekerId(jobSeekerId), Messages.ResumeGetByJobSeeker);
	}

	

}
