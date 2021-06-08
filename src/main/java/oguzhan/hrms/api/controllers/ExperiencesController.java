package oguzhan.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.ExperienceService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	public ExperiencesController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/addexperience")
	public Result addExperience(int resumeId, String companyName, String positionName, 
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)	LocalDate startDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, boolean isWorkingNow) {
		return this.experienceService.add(resumeId, companyName, positionName, startDate, endDate, isWorkingNow);
	}
	
	@GetMapping("/getbyenddate")
	public DataResult<List<Experience>> getByEndDate(int resumeId){
		return this.experienceService.getByEndDate(resumeId);
	}
}
