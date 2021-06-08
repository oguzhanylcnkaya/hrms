package oguzhan.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import oguzhan.hrms.entities.concretes.SocialMediaAccount;

public interface SocialMediaAccountDao extends JpaRepository<SocialMediaAccount, Integer> {

}
