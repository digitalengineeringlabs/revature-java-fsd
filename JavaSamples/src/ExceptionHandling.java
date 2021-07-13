
public class ExceptionHandling {
	
	public static void main(String[] args) {
		
		String message = null;
		
		try {
			
			RegistrationService service = new RegistrationService();
			service.register(0);
			
		} catch (AccountAlreadyExistsException e) {
			//send different message to user
			message = "Account already exists";
			
			//e.printStackTrace();
		} catch (Exception ex) {
			
		}
		
		if(message != null) {
			System.out.println(message);
			//all the logic, such as updating DB with the attempt
		}
		
	}

}


class RegistrationService {
	
	public void register(int id) throws AccountAlreadyExistsException{
		
		UserValidator validator = new UserValidator();
		if(!validator.validate(id)) {
			throw new AccountAlreadyExistsException();
		}
		
	}
	
}

class UserValidator {
	
	boolean validate(int id) {
		//call database to check and return true and false
		return false;
	}
	
}

class AccountAlreadyExistsException extends Exception {
	
}