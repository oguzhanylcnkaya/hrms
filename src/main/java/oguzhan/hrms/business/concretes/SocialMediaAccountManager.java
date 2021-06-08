package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.SocialMediaAccountService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.dataAccess.abstracts.SocialMediaAccountDao;
import oguzhan.hrms.entities.concretes.Resume;
import oguzhan.hrms.entities.concretes.SocialMediaAccount;

@Service
public class SocialMediaAccountManager implements SocialMediaAccountService {

	private SocialMediaAccountDao socialMediaAccountDao;
	private ResumeDao resumeDao;
	
	@Autowired
	public SocialMediaAccountManager(SocialMediaAccountDao socialMediaAccountDao, ResumeDao resumeDao) {
		super();
		this.socialMediaAccountDao = socialMediaAccountDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String githubUrl, String linkedinUrl) {
		Resume resume = this.resumeDao.getById(resumeId);
		
		SocialMediaAccount socialMediaAccount = new SocialMediaAccount(resume, githubUrl, linkedinUrl);
		
		this.socialMediaAccountDao.save(socialMediaAccount);
		return new SuccessResult(Messages.SocialMediaAccountAdded);
	}

}
