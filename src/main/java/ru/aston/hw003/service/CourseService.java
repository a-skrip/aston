package ru.aston.hw003.service;

import ru.aston.hw003.dao.CourseDAO;
import ru.aston.hw003.dto.CourseDTO;
import ru.aston.hw003.dto.CourseWithStudentDTO;
import ru.aston.hw003.dto.StudentDTO;
import ru.aston.hw003.entity.CourseEntity;
import ru.aston.hw003.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

    CourseDAO courseDAO = new CourseDAO();

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

