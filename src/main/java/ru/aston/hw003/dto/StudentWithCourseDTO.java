package ru.aston.hw003.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class StudentWithCourseDTO {

    private StudentDTO studentDTO;
    private List<CourseDTO> courseList;

}
