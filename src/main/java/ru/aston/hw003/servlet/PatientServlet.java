package ru.aston.hw003.servlet;


import com.google.gson.Gson;
import ru.aston.hw003.entity.Patient;
import ru.aston.hw003.service.PatientService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet(name = "Patient", value = "/Patient")
public class PatientServlet extends HttpServlet {

    PatientService patientService = new PatientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

        String id = request.getParameter("id");
        patientService.getPatientById(Long.parseLong(id));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();

        Gson gson = new Gson();
        Patient patientEncoding = gson.fromJson(reader, Patient.class);
        patientService.createPatient(patientEncoding);
    }
}