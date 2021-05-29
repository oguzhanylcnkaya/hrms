package oguzhan.hrms.core.utilities.helpers;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MailVerificationManager implements MailVerificationService {

	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
        String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
        System.out.println("Verification link has been sent to " + email );
        System.out.println("Please click on the link to verify your account:  " + verificationLink );
		
	}

	@Override
	public String sendCode() {
		
		UUID uuid = UUID.randomUUID();
		String code = uuid.toString();
		System.out.println("Aktivasyon kodu:  " + code );
		return code;
	}

}
