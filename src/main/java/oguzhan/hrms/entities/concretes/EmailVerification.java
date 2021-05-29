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
@Entity
@Table(name = "email_verifications")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class EmailVerification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "code")
	private String code;
	
	public EmailVerification(int userId, boolean isConfirmed, String code) {
		super();
		this.userId = userId;
		this.isConfirmed = isConfirmed;
		this.code = code;
	}
}
