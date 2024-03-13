package ru.aston.application.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course", schema = "public")

public class CourseEntity  {
    @ManyToMany(mappedBy = "courseList", fetch = FetchType.EAGER)

    private List<StudentEntity> studentList;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "course_name")
    String courseName;

    @Column
    String school;
}
