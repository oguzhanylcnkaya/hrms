package oguzhan.hrms.core.adapter.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import oguzhan.hrms.core.adapter.abstracts.MernisCheckService;
import oguzhan.hrms.core.utilities.results.Result;
import oguzhan.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisServiceAdapter implements MernisCheckService{

	@Override
	public boolean validate(String identityNumber, String firstName, String lastName, LocalDate birthDate) {
		return true;
	}

}
