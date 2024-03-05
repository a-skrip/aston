package ru.aston.hw003.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course", schema = "public")
@Transactional
public class CourseEntity {
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