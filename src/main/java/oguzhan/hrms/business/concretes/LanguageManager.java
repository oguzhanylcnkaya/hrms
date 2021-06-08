package oguzhan.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oguzhan.hrms.business.abstracts.LanguageService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.LanguageDao;
import oguzhan.hrms.dataAccess.abstracts.ResumeDao;
import oguzhan.hrms.entities.concretes.Language;
import oguzhan.hrms.entities.concretes.Resume;

@Service
public class LanguageManager  implements LanguageService{

	private LanguageDao languageDao;
	private ResumeDao resumeDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao, ResumeDao resumeDao) {
		super();
		this.languageDao = languageDao;
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(int resumeId, String languageName, Short level) {
		
		Resume resume = this.resumeDao.getById(resumeId);
		
		Language language = new Language(resume, languageName, level);
		
		this.languageDao.save(language);
		return new SuccessResult(Messages.LanguageAdded);
	}

}
