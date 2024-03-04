package ru.aston.hw003.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patient", schema = "public")
public class Patient {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "doctor_id")
//    private Long doctorId;
    @Column
    private String name;

    public Patient(Long id, Long doctorId, String name) {
        this.id = id;
//        this.doctorId = doctorId;
        this.name = name;
    }

    public Patient() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}



