package businesslayer.services;

import dataaccesslayer.repositories.UserRepository;
import models.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance = null;
    private static UserRepository userRepository = null;

    UserService() {
        this.userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance(){

        if (UserService.instance == null) {
            UserService.instance = new UserService();
        }

        return UserService.instance;
    }

    public static List<User> getAllUsers() throws SQLException {
        return UserRepository.getAllUsers();
    }

    public static User getUserById(int userId) throws SQLException{
        return UserRepository.getUserById(userId);
    }

    public static void updateUser(User user) throws SQLException{
        UserRepository.updateUser(user);
    }

    public static void deleteUser(User user) throws SQLException {
        UserRepository.deleteUser(user);
    }

    public User getRegisteredUser(String username, String password) {

        return userRepository.getRegisteredUser(username, password);
    }


    public static boolean authenticateUser(String username, String password) throws SQLException {
        List<User> userList = getAllUsers();

        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}