package ru.aston.hw003.servlet;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.aston.hw003.dto.DoctorWithPatientDTO;
import ru.aston.hw003.dto.PatientDTO;
import ru.aston.hw003.entity.Patient;
import ru.aston.hw003.service.PatientService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Patient", value = "/Patient")
public class PatientServlet extends HttpServlet {

    PatientService patientService = new PatientService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        PatientDTO patientById = patientService.getPatientById(Long.parseLong(id));

        String patientJsonString = new Gson().toJson(patientById);


        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(patientJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();

        Gson gson = new Gson();
        Patient patientEncoding = gson.fromJson(reader, Patient.class);
        patientService.createPatient(patientEncoding);
    }
}