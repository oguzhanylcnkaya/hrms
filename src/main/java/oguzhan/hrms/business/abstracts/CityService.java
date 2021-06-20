package oguzhan.hrms.business.abstracts;

import java.util.List;

import oguzhan.hrms.core.utilities.results.DataResult;
import oguzhan.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
