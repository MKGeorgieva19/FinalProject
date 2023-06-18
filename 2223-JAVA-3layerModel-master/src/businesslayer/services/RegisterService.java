package businesslayer.services;

import dataaccesslayer.repositories.UserRepository;
import models.User;
import utils.PasswordManager;

import java.sql.SQLException;

public class RegisterService {
	
	private final UserRepository usersRepository;
	private static RegisterService instance = null;
	private boolean correctUser;
	
	private RegisterService() {
        this.usersRepository = UserRepository.getInstance();
    }
	
	public static RegisterService getInstance() {

        if (RegisterService.instance == null) {
        	RegisterService.instance = new RegisterService();
		}

        return RegisterService.instance;
    }
	
	public boolean getCorrectUser() {
        return correctUser;
    }

	public void insertUser(User user) throws SQLException {
		
		String salt = PasswordManager.getNextSalt();
		user.setPassword(PasswordManager.hash(user.getPassword().toCharArray(), salt));
		
		correctUser = usersRepository.insertInto(user);
	}
	
	public void destroyCurrentRegisteredUser() {
		correctUser = false;  	
    }
}