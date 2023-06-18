package repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import dataaccesslayer.repositories.UserRepository;
import models.User;
import org.junit.jupiter.api.Test;

class getAllUsersTest {

	@Test
	void getAllUsersTests() throws SQLException {
		UserRepository test= new UserRepository();
		List<User>tests=test.getAllUsers();
		assertNotNull(tests);
		
	}
}