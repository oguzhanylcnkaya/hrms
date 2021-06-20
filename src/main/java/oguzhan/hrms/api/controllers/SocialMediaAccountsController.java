package oguzhan.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.SocialMediaAccountService;
import oguzhan.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/socialmediaaccounts")
@CrossOrigin
public class SocialMediaAccountsController {
	
	private SocialMediaAccountService socialMediaAccountService;

	public SocialMediaAccountsController(SocialMediaAccountService socialMediaAccountService) {
		super();
		this.socialMediaAccountService = socialMediaAccountService;
	}
	
	@PostMapping("/addsocialmediaaccount")
	public Result addSocialMediaAccount(int resumeId, String githubUrl, String linkedinUrl) {
		return this.socialMediaAccountService.add(resumeId, githubUrl, linkedinUrl);
	}
}
