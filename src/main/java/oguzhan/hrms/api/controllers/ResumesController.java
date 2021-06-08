package oguzhan.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import oguzhan.hrms.business.abstracts.ResumeService;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	
	private ResumeService resumeService;

	public ResumesController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("/createcv")
	public Result createCV(@RequestParam int jobSeekerId) {
		return this.resumeService.add(jobSeekerId);
	}
	
	@GetMapping("/getbyresumeid")
	public DataResult<Resume> getById(@RequestParam int resumeId){
		return this.resumeService.getById(resumeId);
	}
	
	@GetMapping("/getbyjobseeker")
	public DataResult<List<Resume>> getByJobSeekerId(@RequestParam int jobSeekerId){
		return this.resumeService.getByJobSeekerId(jobSeekerId);
	}
	
}
