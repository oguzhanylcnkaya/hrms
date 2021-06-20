package oguzhan.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oguzhan.hrms.business.abstracts.WorkTypeService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.WorkType;

@RequestMapping("/api/worktypes")
@RestController
@CrossOrigin
public class WorkTypesController {
	
	private WorkTypeService workTypeService;

	@Autowired
	public WorkTypesController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody String workType) {
		return this.workTypeService.add(workType);
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	}
}
