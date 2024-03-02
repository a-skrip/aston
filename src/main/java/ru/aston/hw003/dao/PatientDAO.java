package ru.aston.hw003.dao;

import ru.aston.hw003.entity.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

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

    public List<Patient> getPatientListByDoctorId(long doctorId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM public.patient WHERE doctor_id = ?")) {

            preparedStatement.setLong(1, doctorId);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Patient> patientList = new ArrayList<>();

            while (resultSet.next()) {
                Patient patientFromResultSet = getPatientFromResultSet(resultSet);
                patientList.add(patientFromResultSet);
            }
            return patientList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Patient addPatient(Long doctor_id, String name) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "INSERT INTO public.patient (doctor_id, name) values (?, ?) returning *;")) {


            preparedStatement.setLong(1, doctor_id);
            preparedStatement.setString(2, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Patient patient = getPatientFromResultSet(resultSet);

                return patient;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Patient getPatientById(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "SELECT * FROM public.patient WHERE id=?;")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return getPatientFromResultSet(resultSet);

            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> getListPatient() {
        List<Patient> patientList = new ArrayList<>();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT * FROM public.patient;")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                patientList.add(getPatientFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patientList;
    }

    public void deletePatient(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement("DELETE FROM public.patient WHERE id=?;")) {

            preparedStatement.setLong(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient updatePatient(long id, Patient patient) {

        long doctor_id = patient.getDoctorId();
        String name = patient.getName();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(
                "UPDATE public.patient SET name = ?, doctor_id = ? WHERE id=? returning *;")) {
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, doctor_id);
            preparedStatement.setLong(3, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return getPatientFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Patient getPatientFromResultSet(ResultSet resultSet) throws SQLException {

        long idAdd = resultSet.getInt("id");
        Long doctor_id = resultSet.getLong("doctor_id");
        String nameAdd = resultSet.getString("name");

        Patient patient = new Patient(idAdd, doctor_id, nameAdd);
        return patient;

    }
}


