package oguzhan.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resumes")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobSeeker"})
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "create_date")
	private LocalDate createDate = LocalDate.now();
	
	@OneToMany(mappedBy = "resume")
	private List<School> schools;
	
	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<Experience> experiences;
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "resume")
	private List<CoverLetter> coverLetters;
	
	
	@OneToOne(mappedBy = "resume")
	private SocialMediaAccount socialMediaAccount;
	
	public Resume(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}
}
