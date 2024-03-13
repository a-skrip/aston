package ru.aston.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor
public class CourseWithStudentDTO {

    private CourseDTO courseDTO;
    private List<StudentDTO> studentList;
}
