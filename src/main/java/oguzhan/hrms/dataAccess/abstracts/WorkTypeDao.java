package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.WorkType;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {

}
