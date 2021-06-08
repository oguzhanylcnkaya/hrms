package oguzhan.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "languages")
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name")
	@NotBlank
	@NotNull
	private String languageName;
	
	@Column(name = "level")
	@Min(1)
	@Max(5)
	@NotBlank
	@NotNull
	private Short level;
	
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	public Language(Resume resume, String languageName, Short level) {
		this.resume = resume;
		this.languageName = languageName;
		this.level = level;
	}
}
