package ru.aston.hw003.servlet;


import com.google.gson.Gson;
import ru.aston.hw003.Doctor;
import ru.aston.hw003.dto.DoctorDTO;
import ru.aston.hw003.service.DoctorService;

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
    DoctorService doctorService  = new DoctorService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        DoctorDTO doctorWithPatient = doctorService.getDoctorWithPatient(Long.valueOf(id));

        String userJsonString = new Gson().toJson(doctorWithPatient);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(userJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        Gson gson = new Gson();
        Doctor doctorEncoding = gson.fromJson(reader, Doctor.class);
        doctorService.createDoctor(doctorEncoding);
    }

//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        userService.deleteUserById(Long.parseLong(id));
//    }

//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String id = req.getParameter("id");
//        BufferedReader reader = req.getReader();
//        Gson gson = new Gson();
//        User userEncoding = gson.fromJson(reader, User.class);
//        userService.updateUser(Long.parseLong(id), userEncoding);
//    }
}