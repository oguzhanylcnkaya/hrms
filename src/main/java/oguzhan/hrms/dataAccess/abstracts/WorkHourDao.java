package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.WorkHour;

public interface WorkHourDao extends JpaRepository<WorkHour, Integer> {

}
