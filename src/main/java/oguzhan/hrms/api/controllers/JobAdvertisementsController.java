package oguzhan.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.JobAdvertisementService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.JobAdvertisement;
import oguzhan.hrms.entities.dtos.JobAdvertisementForDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("getAllJobAdvertisementForDto")
	public DataResult<List<JobAdvertisementForDto>> getJobAdvertisementForDto(){
		return this.jobAdvertisementService.getAllJobAdvertisementForDto();
	}
	
	@GetMapping("getActiveJobAdvertisement")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisement(){
		return this.jobAdvertisementService.getActiveJobAdvertisement();
	}
	
	@GetMapping("getActiveJobAdvertisementByCreateDate")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDate(){
		return this.jobAdvertisementService.getActiveJobAdvertisementByCreateDate();
	}
	
	@GetMapping("getActiveJobAdvertisementByCreateDateDesc")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCreateDateDesc(){
		return this.jobAdvertisementService.getActiveJobAdvertisementByCreateDateDesc();
	}
	
	@GetMapping("getActiveJobAdvertisementByApplicationDeadline")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadline(){
		return this.jobAdvertisementService.getActiveJobAdvertisementByApplicationDeadline();
	}
	
	@GetMapping("getActiveJobAdvertisementByApplicationDeadlineDesc")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByApplicationDeadlineDesc(){
		return this.jobAdvertisementService.getActiveJobAdvertisementByApplicationDeadlineDesc();
	}
	
	@GetMapping("getActiveJobAdvertisementByCompanyName")
	public DataResult<List<JobAdvertisementForDto>> getActiveJobAdvertisementByCompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getActiveJobAdvertisementByCompanyName(companyName);
	}
	
	@PostMapping("/doPassiveTheAdvertisement")
	public Result doPassiveTheAdvertisement(int id) {
		return this.jobAdvertisementService.doPassiveTheAdvertisement(id);
	}
}
