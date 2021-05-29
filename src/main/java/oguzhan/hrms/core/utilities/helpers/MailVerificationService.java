package oguzhan.hrms.core.utilities.helpers;

public interface MailVerificationService {
	void sendLink(String email);
	String sendCode();
}
