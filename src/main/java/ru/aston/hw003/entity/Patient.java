package ru.aston.hw003.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "patient", schema = "public")

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column
    private String name;

    public Patient(Long id, Long doctorId, String name) {
        this.id = id;
        this.doctorId = doctorId;
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

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", name='" + name + '\'' +
                '}';
    }
}


