package ru.aston.hw003.dao;

import ru.aston.hw003.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM public.user;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public void deleteUser(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM public.user WHERE id=?;")) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User addUser(String name, String postCode, String profession) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "INSERT INTO public.user (name, post_code, profession) values (?, ?, ?) returning *;")) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, postCode);
            preparedStatement.setString(3, profession);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = getUserFromResultSet(resultSet);
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


        public User getUserById(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT id, name, post_code, profession FROM public.user WHERE id=?;")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                long idAdd = resultSet.getInt("id");
                String nameAdd = resultSet.getString("name");
                String post_codeAdd = resultSet.getString("post_code");
                String professionAdd = resultSet.getString("profession");

                User user = new User(idAdd, nameAdd, post_codeAdd, professionAdd);
                return user;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User updateUser(long id, User userFromRequest) {

        String nameUpdate = userFromRequest.getName();
        String postCodeUpdate = userFromRequest.getPostCode();
        String professionUpdate = userFromRequest.getProfession();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "UPDATE public.user SET name = ?, post_code = ?, profession = ? WHERE id=? returning *;")) {
            preparedStatement.setString(1, nameUpdate);
            preparedStatement.setString(2, postCodeUpdate);
            preparedStatement.setString(3, professionUpdate);
            preparedStatement.setLong(4, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = getUserFromResultSet(resultSet);
                return user;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {

        long idAdd = resultSet.getInt("id");
        String nameAdd = resultSet.getString("name");
        String post_codeAdd = resultSet.getString("post_code");
        String professionAdd = resultSet.getString("profession");

        User user = new User(idAdd, nameAdd, post_codeAdd, professionAdd);
        return user;

    }
}


