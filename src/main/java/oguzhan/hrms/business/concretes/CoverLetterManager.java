package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.CoverLetterService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.CoverLetterDao;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.entities.concretes.CoverLetter;
import oguzhan.hrms.entities.concretes.Resume;

@Service
public class CoverLetterManager implements CoverLetterService {

	private CoverLetterDao coverLetterDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public CoverLetterManager(CoverLetterDao coverLetterDao, ResumeDao resumeDao) {
		super();
		this.coverLetterDao = coverLetterDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String coverLetterText) {
		Resume resume = this.resumeDao.getById(resumeId);
		
		CoverLetter coverLetter = new CoverLetter(resume, coverLetterText);
		
		this.coverLetterDao.save(coverLetter);
		return new SuccessResult(Messages.CoverLetterAdded);
	}

}
