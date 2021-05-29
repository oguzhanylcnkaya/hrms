package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer>{

}
