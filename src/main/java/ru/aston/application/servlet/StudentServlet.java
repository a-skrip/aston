package ru.aston.application.servlet;

import com.google.gson.Gson;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import ru.aston.application.config.AppConfig;
import ru.aston.application.dto.StudentWithCourseDTO;
import ru.aston.application.entity.StudentEntity;
import ru.aston.application.service.CourseService;
import ru.aston.application.service.StudentService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StudentServlet", value = "/StudentServlet")

public class StudentServlet extends HttpServlet {

    private StudentService studentService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        studentService = context.getBean(StudentService.class);
    }

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