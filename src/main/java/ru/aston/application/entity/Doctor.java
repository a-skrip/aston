package ru.aston.application.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor", schema = "public")
@Data
@NoArgsConstructor
public class Doctor {

    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Patient> patient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String specialization;
    @Column(name = "phone_number")
    private String phoneNumber;

}
