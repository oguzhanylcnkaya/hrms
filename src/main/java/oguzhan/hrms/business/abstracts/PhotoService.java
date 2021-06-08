package oguzhan.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.entities.concretes.Photo;

public interface PhotoService {
	Result add(int jobSeekerId, MultipartFile imageFile);
	
	DataResult<List<Photo>> getByJobSeekerId(int jobSeekerId);
}
