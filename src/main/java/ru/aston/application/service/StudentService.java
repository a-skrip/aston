package ru.aston.application.service;

import org.springframework.stereotype.Service;
import ru.aston.application.dao.DoctorDAO;
import ru.aston.application.dao.StudentDAO;
import ru.aston.application.dto.CourseDTO;
import ru.aston.application.dto.StudentDTO;
import ru.aston.application.dto.StudentWithCourseDTO;
import ru.aston.application.entity.CourseEntity;
import ru.aston.application.entity.StudentEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;

    }

    public StudentWithCourseDTO getStudentById(long id) {

        StudentEntity studentById = studentDAO.getStudentByID(id);
        StudentDTO studentDTO = new StudentDTO(studentById.getName(), studentById.getPhone());

        List<CourseEntity> courses = studentById.getCourseList();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        for (CourseEntity elem : courses) {
            CourseDTO covertToDTO = new CourseDTO(elem.getCourseName(), elem.getSchool());
            courseDTOList.add(covertToDTO);
        }
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
