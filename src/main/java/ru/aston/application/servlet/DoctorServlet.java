package ru.aston.application.servlet;


import com.google.gson.Gson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import ru.aston.application.config.AppConfig;
import ru.aston.application.dto.DoctorWithPatientDTO;
import ru.aston.application.entity.Doctor;
import ru.aston.application.service.CourseService;
import ru.aston.application.service.DoctorService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "Doctor", value = "/Doctor")
public class DoctorServlet extends HttpServlet {
    private DoctorService doctorService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        doctorService = context.getBean(DoctorService.class);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        DoctorWithPatientDTO doctorById = doctorService.getDoctorById(Long.parseLong(id));

        String doctorJsonString = new Gson().toJson(doctorById);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(doctorJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();

        Gson gson = new Gson();
        Doctor doctorEncoding = gson.fromJson(reader, Doctor.class);
        doctorService.createDoctor(doctorEncoding);
    }
}