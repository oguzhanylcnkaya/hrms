package oguzhan.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import oguzhan.hrms.business.abstracts.SchoolService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {
	
	private SchoolService schoolService;
	
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/addschool")
	public Result addSchool(int resumeId, String schoolName, String department,
			@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(name ="endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,boolean isGraduated) {
		
		System.out.println(resumeId);
		return this.schoolService.add(resumeId, schoolName, department, startDate, endDate, isGraduated);
	}
	
	@GetMapping("/getbyenddate")
	public DataResult<List<School>> getByEndDate(@RequestParam int resumeId){
		return this.schoolService.getByEndDate(resumeId);
	}
}
