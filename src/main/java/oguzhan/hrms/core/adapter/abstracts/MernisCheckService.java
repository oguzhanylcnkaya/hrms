package oguzhan.hrms.core.adapter.abstracts;

import java.time.LocalDate;

import oguzhan.hrms.core.utilities.results.Result;

public interface MernisCheckService {
	boolean validate(String identityNumber, String firstName, String lastName, LocalDate birthDate);
}
