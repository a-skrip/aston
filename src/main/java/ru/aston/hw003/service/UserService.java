package ru.aston.hw003.service;

import ru.aston.hw003.User;
import ru.aston.hw003.dao.UserDAO;

import java.util.List;

public class UserService {

    UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {

        return userDAO.getUserList();

    }

    public User createUser(User user) {

        return userDAO.addUser(user);

    }

    public void deleteUserById(long id) {

        userDAO.deleteUser(id);

    }
    public void updateUser(long id, User userFrom) {

        userDAO.updateUser(id, userFrom);

    }


}
