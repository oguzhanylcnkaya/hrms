package oguzhan.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "experiences")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Experience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "position_name")
	private String positionName;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	
	@Column(name = "is_working_now")
	private boolean isWorkingNow;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public Experience(String companyName, String positionName, LocalDate startDate, boolean isWorkingNow, Resume resume) {
		super();
		this.companyName = companyName;
		this.positionName = positionName;
		this.startDate = startDate;
		this.isWorkingNow = isWorkingNow;
		this.resume = resume;
	}
	
	public Experience(String companyName, String positionName, LocalDate startDate, LocalDate endDate, boolean isWorkingNow, Resume resume) {
		super();
		this.companyName = companyName;
		this.positionName = positionName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isWorkingNow = isWorkingNow;
		this.resume = resume;
	}
}
