package ru.aston.hw003.servlet;


import com.google.gson.Gson;
import ru.aston.hw003.entity.Doctor;
import ru.aston.hw003.service.DoctorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "Doctor", value = "/Doctor")
public class DoctorServlet extends HttpServlet {
    DoctorService doctorService = new DoctorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        Doctor doctor = doctorService.getDoctorById(Long.parseLong(id));

        String userJsonString = new Gson().toJson(doctor);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userJsonString);
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