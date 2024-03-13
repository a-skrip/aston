package ru.aston.application.servlet;


import com.google.gson.Gson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import ru.aston.application.config.AppConfig;
import ru.aston.application.dto.PatientDTO;
import ru.aston.application.entity.Patient;
import ru.aston.application.service.CourseService;
import ru.aston.application.service.PatientService;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "Patient", value = "/Patient")
public class PatientServlet extends HttpServlet {

    private PatientService patientService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        patientService = context.getBean(PatientService.class);
    }

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