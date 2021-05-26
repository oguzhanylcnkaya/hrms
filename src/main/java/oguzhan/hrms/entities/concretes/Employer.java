package oguzhan.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import oguzhan.hrms.core.entities.concretes.User;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "userid")
public class Employer extends User{
	
	@Column(name = "companyname", nullable = false)
	private String companyName;
	
	@Column(name = "website", nullable = false)
	private String website;
	
	@Column(name = "phonenumber", nullable = false)
	private String phoneNumber;
}
