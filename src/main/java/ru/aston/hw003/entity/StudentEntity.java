package ru.aston.hw003.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student", schema = "public")
@Entity

public class StudentEntity extends BaseEntity{

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_course",
            joinColumns = { @JoinColumn(name = "student_id") },
            inverseJoinColumns = { @JoinColumn(name = "course_id") })

//    @ManyToMany(mappedBy = "studentList", fetch = FetchType.EAGER)

    private List<CourseEntity> courseList;




    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @Column
    String name;

    @Column
    String phone;


}
