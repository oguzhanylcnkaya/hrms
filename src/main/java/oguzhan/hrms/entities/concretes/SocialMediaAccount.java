package oguzhan.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "social_media_accounts")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class SocialMediaAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "github_url")
	private String githubUrl;
	
	@Column(name = "linkedin_url")
	private String linkedinUrl;
	
	@OneToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public SocialMediaAccount(Resume resume, String githubUrl, String linkedinUrl) {
		this.resume = resume;
		this.githubUrl = githubUrl;
		this.linkedinUrl = linkedinUrl;
	}
}
