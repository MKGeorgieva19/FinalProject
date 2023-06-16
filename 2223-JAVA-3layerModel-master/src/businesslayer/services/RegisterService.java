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

	public void insertUser(String username, String password, String address, String phone, String email) throws SQLException {
		
		String salt = PasswordManager.getNextSalt();
		password = PasswordManager.hash(password.toCharArray(), salt);
		
		correctUser = usersRepository.insertInto(username, password, address, phone, email);
	}
	
	public void destroyCurrentRegisteredUser() {
		correctUser = false;  	
    }
}