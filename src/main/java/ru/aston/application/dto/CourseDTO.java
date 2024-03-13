package ru.aston.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CourseDTO {

    private String courseName;
    private String school;
}
