package ru.aston.hw003.dao;

import ru.aston.hw003.Doctor;
import ru.aston.hw003.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {


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

    public Doctor addDoctor(String name, String specialization, String phone_number) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "INSERT INTO public.doctor (name, specialization, phone_number) values (?, ?, ?) returning *;")) {


            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specialization);
            preparedStatement.setString(3, phone_number);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Doctor doctor = getDoctorsFromResultSet(resultSet);

                return doctor;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Doctor getDoctorById(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT id, name, specialization, phone_number FROM public.doctor WHERE id=?;")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Doctor doctor = getDoctorsFromResultSet(resultSet);
                return doctor;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Doctor> getListDoctors() {
        List<Doctor> doctorsList = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM public.doctor;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctorsList.add(getDoctorsFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return doctorsList;
    }

    public void deleteDoctor(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM public.doctor WHERE id=?;")) {

            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public Doctor updateDoctor(long id, Doctor doctor) {

        String name = doctor.getName();
        String specialization = doctor.getSpecialization();
        String phoneNumber = doctor.getPhoneNumber();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "UPDATE public.doctor SET name = ?, specialization = ?, phone_number = ? WHERE id=? returning *;")) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, specialization);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setLong(4, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getDoctorsFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Doctor getDoctorsFromResultSet(ResultSet resultSet) throws SQLException {

        long idAdd = resultSet.getLong("id");
        String nameAdd = resultSet.getString("name");
        String professionAdd = resultSet.getString("specialization");
        String phoneNumberAdd = resultSet.getString("phone_number");

        return new Doctor(idAdd, nameAdd, professionAdd, phoneNumberAdd);

    }
}

