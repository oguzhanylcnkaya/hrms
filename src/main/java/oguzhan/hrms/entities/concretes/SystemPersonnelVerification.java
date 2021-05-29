package oguzhan.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system_personnel_verifications")
@PrimaryKeyJoinColumn(name = "employerid")
public class SystemPersonnelVerification {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "employerid")
	private int employerId;
	
	@Column(name = "isconfirmed")
	private boolean isConfirmed;
	
	public SystemPersonnelVerification(int employerId, boolean isConfirmed){
		super();
		this.employerId = employerId;
		this.isConfirmed = isConfirmed;
	}
}
