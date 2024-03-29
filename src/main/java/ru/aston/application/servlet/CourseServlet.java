package ru.aston.application.servlet;

import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import ru.aston.application.config.AppConfig;
import ru.aston.application.dto.CourseWithStudentDTO;
import ru.aston.application.entity.CourseEntity;
import ru.aston.application.service.CourseService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CourseServlet", value = "/CourseServlet")

public class CourseServlet extends HttpServlet {

    private CourseService courseService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        courseService = context.getBean(CourseService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        BufferedReader reader = request.getReader();

        Gson json = new Gson();
        CourseEntity course = json.fromJson(reader, CourseEntity.class);
        courseService.addCourse(course);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id = request.getParameter("id");
        courseService.deleteCourse(Long.parseLong(id));

    }
}