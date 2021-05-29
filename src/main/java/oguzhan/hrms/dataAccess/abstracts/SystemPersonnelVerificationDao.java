package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.SystemPersonnelVerification;

public interface SystemPersonnelVerificationDao extends JpaRepository<SystemPersonnelVerification, Integer>{

}
