package oguzhan.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementForDto {
	
	private String companyName;
	
	private String jobName;
	
	private int openPositionQuantity;
	
	private LocalDate createDate;
	
	private LocalDate applicationDeadline;
}
