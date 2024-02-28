package ru.aston.hw003.dao;

import ru.aston.hw003.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    static List<User> userList = new ArrayList<>();

    public UserDAO() {
        userList.add(new User(1L, "Alex", "141407", "student"));
        userList.add(new User(2L, "Jonny", "109559", "freelancer"));
        userList.add(new User(3L, "Garry", "542015", "jobber"));
        userList.add(new User(4L, "Piter", "247991", "fighter"));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void deleteUser(long id) {

        User userById = getUserById(id);
        userList.remove(userById);

    }

    public User addUser(User user) {
        boolean add = userList.add(user);
        return user;
    }

    public User getUserById(long id) {

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            long userId = user.getId();
            if (id == userId) {
                return user;
            }
        }
        throw new RuntimeException("User " + id + " not Found");
    }

    public User updateUser(long id, User userFromRequest) {

        User userById = getUserById(id);
        userById.setName(userFromRequest.getName());
        userById.setPostCode(userFromRequest.getPostCode());
        userById.setProfession(userFromRequest.getProfession());


        return userById;
    }

}
