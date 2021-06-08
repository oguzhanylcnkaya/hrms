package oguzhan.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.LanguageService;
import oguzhan.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@PostMapping("/addLanguage")
	public Result addLanguage(int resumeId, String languageName, Short level) {
		return this.languageService.add(resumeId, languageName, level);
	}
}
