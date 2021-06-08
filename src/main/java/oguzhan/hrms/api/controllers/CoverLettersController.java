package oguzhan.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.CoverLetterService;
import oguzhan.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersController {

	private CoverLetterService coverLetterService;

	public CoverLettersController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/addCoverLetter")
	public Result addCoverLetter(int resumeId, String coverLetter) {
		return this.coverLetterService.add(resumeId, coverLetter);
	}
}
