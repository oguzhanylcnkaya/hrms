package oguzhan.hrms.core.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.ErrorDataResult;
import oguzhan.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService{

	private Cloudinary cloudinary;
	
	public CloudinaryManager() {
		
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "oguzhanyalcinkaya",
				"api_key", "152874445665392",
				"api_secret", "euIS-NEjLwg4L4Ite_dv0seMwWk"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imagefile) {
		try {
			
			@SuppressWarnings("unchecked")
			Map<String, String> result = (Map<String, String>) cloudinary.uploader().upload(imagefile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(result);
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		return new ErrorDataResult<Map>();
	}
	
}
