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
@NoArgsConstructor
@Entity
@Table(name = "schools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date")
	private LocalDate endDate;
	
	@Column(name = "is_graduated")
	private boolean isGraduated;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public School(Resume resume, String schoolName, String department, LocalDate startDate, LocalDate endDate, boolean isGraduated) {
		super();
		this.resume = resume;
		this.schoolName = schoolName;
		this.department = department;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isGraduated = isGraduated;
	}
	
	public School(Resume resume, String schoolName, String department, LocalDate startDate, boolean isGraduated) {
		super();
		this.resume = resume;
		this.schoolName = schoolName;
		this.department = department;
		this.startDate = startDate;
		this.isGraduated = isGraduated;
	}
}
