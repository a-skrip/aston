package ru.aston.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.application.dao.CourseDAO;
import ru.aston.application.dto.CourseDTO;
import ru.aston.application.dto.CourseWithStudentDTO;
import ru.aston.application.dto.StudentDTO;
import ru.aston.application.entity.CourseEntity;
import ru.aston.application.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public CourseWithStudentDTO getCourseById(long id) {

        CourseEntity courseById = courseDAO.getCourseById(id);
        CourseDTO courseDTO = new CourseDTO(courseById.getCourseName(), courseById.getSchool());

        List<StudentEntity> studentList = courseById.getStudentList();
        List<StudentDTO> studentDTO = new ArrayList<>();
        for (StudentEntity elem : studentList) {
            StudentDTO covertToDTO = new StudentDTO(elem.getName(), elem.getPhone());
            studentDTO.add(covertToDTO);
        }


        return new CourseWithStudentDTO(courseDTO, studentDTO);
    }


    public void addCourse(CourseEntity courseEntity) {
        courseDAO.addCourse(courseEntity);
    }

    public void deleteCourse(long id) {
        courseDAO.deleteCourse(id);
    }

}

