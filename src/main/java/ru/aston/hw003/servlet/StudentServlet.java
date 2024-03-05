package ru.aston.hw003.servlet;

import com.google.gson.Gson;
import ru.aston.hw003.dto.StudentWithCourseDTO;
import ru.aston.hw003.entity.StudentEntity;
import ru.aston.hw003.service.StudentService;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")
public class StudentServlet extends HttpServlet {

    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        StudentWithCourseDTO studentById = studentService.getStudentById(Long.parseLong(id));

        String json = new Gson().toJson(studentById);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();

        Gson gson = new Gson();
        StudentEntity studentEntity = gson.fromJson(reader, StudentEntity.class);
        studentService.addStudent(studentEntity);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        studentService.deleteStudent(Long.parseLong(id));

    }
}