package oguzhan.hrms.api.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.TechnologyService;
import oguzhan.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/technologies")
@CrossOrigin
public class TechnologiesController {
	
	private TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("/addtechnology")
	public Result addTechnology(int resumeId, String technologyName) {
		return this.technologyService.add(resumeId, technologyName);
	}
}
