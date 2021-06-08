package oguzhan.hrms.core.services;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import oguzhan.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {

	DataResult<Map> uploadImageFile(MultipartFile imagefile);
}
