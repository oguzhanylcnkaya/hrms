package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.core.entities.concretes.User;



public interface UserDao extends JpaRepository<User, Integer> {

}
