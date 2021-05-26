package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.entities.concretes.User;
import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	Result add(User user);
}
