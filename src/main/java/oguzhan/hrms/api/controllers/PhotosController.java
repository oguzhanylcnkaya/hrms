package oguzhan.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import oguzhan.hrms.business.abstracts.PhotoService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotosController {
	
	private PhotoService photoService;
	
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}

	@PostMapping("/addphoto")
	public Result add(int jobSeekerId, MultipartFile imageFile) {
		return this.photoService.add(jobSeekerId, imageFile);
	}
	
	@GetMapping("/getbyjobseeker")
	public DataResult<List<Photo>> getByJobSeekerId(@RequestParam int jobSeekerId){
		return this.photoService.getByJobSeekerId(jobSeekerId);
	}
}
