package oguzhan.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import oguzhan.hrms.business.abstracts.PhotoService;
import oguzhan.hrms.business.constants.Messages;
import oguzhan.hrms.core.services.CloudinaryService;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;
import oguzhan.hrms.core.utilities.results.SuccessResult;
import oguzhan.hrms.dataAccess.abstracts.JobSeekerDao;
import oguzhan.hrms.dataAccess.abstracts.PhotoDao;

import oguzhan.hrms.entities.concretes.JobSeeker;
import oguzhan.hrms.entities.concretes.Photo;


@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao, CloudinaryService cloudinaryService, JobSeekerDao jobSeekerDao) {
		super();
		this.photoDao = photoDao;
		this.cloudinaryService = cloudinaryService;
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(int jobSeekerId, MultipartFile imageFile) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(jobSeekerId);
		
		@SuppressWarnings("unchecked")
		Map<String, String> uploadImage = this.cloudinaryService.uploadImageFile(imageFile).getData();
		
		System.out.println("image url adresi");
		System.out.println(uploadImage.get("url"));
		
		Photo photo = new Photo(jobSeeker, uploadImage.get("url"));
		this.photoDao.save(photo);
		return new SuccessResult(Messages.PhotoAdded);
		
	}

	@Override
	public DataResult<List<Photo>> getByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Photo>>(this.photoDao.getByJobSeekerId(jobSeekerId), Messages.PhotoByJobSeeker);
	}

}
