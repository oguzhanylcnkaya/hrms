package oguzhan.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.WorkHourService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.WorkHour;

@RestController
@RequestMapping("/api/workhours")
@CrossOrigin
public class WorkHoursController {

	private WorkHourService workHourService;
	
	@Autowired
	public WorkHoursController(WorkHourService workHourService) {
		super();
		this.workHourService = workHourService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody String workHour) {
		return this.workHourService.add(workHour);
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkHour>> getAll(){
		return this.workHourService.getAll();
	}
}
