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

public class CourseEntity extends BaseEntity {
    @ManyToMany(mappedBy = "courseList", fetch = FetchType.EAGER)

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "student_course",
//            joinColumns = { @JoinColumn(name = "course_id") },
//            inverseJoinColumns = { @JoinColumn(name = "student_id") })

    private List<StudentEntity> studentList;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @Column(name = "course_name")
    String courseName;

    @Column
    String school;
}
