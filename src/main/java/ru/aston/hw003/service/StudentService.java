package ru.aston.hw003.service;

import ru.aston.hw003.dao.StudentDAO;
import ru.aston.hw003.dto.CourseDTO;
import ru.aston.hw003.dto.StudentDTO;
import ru.aston.hw003.dto.StudentWithCourseDTO;
import ru.aston.hw003.entity.CourseEntity;
import ru.aston.hw003.entity.StudentEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService {

    StudentDAO studentDAO = new StudentDAO();

    public StudentWithCourseDTO getStudentById(long id) {

        StudentEntity studentById = studentDAO.getStudentByID(id);
        StudentDTO studentDTO = new StudentDTO(studentById.getName(), studentById.getPhone());

        List<CourseEntity> courses = studentById.getCourseList();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (CourseEntity elem : courses) {
            CourseDTO covertToDTO = new CourseDTO(elem.getCourseName(), elem.getSchool());
            courseDTOList.add(covertToDTO);
        }
        Objects
        return new StudentWithCourseDTO(
                studentDTO, courseDTOList);
    }

    public void addStudent(StudentEntity studentEntity) {
        studentDAO.addStudent(studentEntity);
    }
    public void deleteStudent(long id) {
        studentDAO.deleteStudent(id);
    }
}
