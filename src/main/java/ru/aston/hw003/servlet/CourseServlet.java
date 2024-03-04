package ru.aston.hw003.servlet;

import com.google.gson.Gson;
import ru.aston.hw003.dto.CourseWithStudentDTO;
import ru.aston.hw003.entity.CourseEntity;
import ru.aston.hw003.service.CourseService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CourseServlet", value = "/CourseServlet")
public class CourseServlet extends HttpServlet {

    CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        CourseWithStudentDTO courseById = courseService.getCourseById(Long.parseLong(id));

        String json = new Gson().toJson(courseById);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();

        Gson json = new Gson();
        CourseEntity course = json.fromJson(reader, CourseEntity.class);
        courseService.addCourse(course);
    }
}